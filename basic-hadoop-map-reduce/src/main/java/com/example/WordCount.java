package com.example;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * This is a hadoop map-reduce demo,
 * The functionality is to count the words
 */
public class WordCount {

    /**
     * 这个类是 map-reduce 的 Mapper 类
     * 继承自 org.apache.hadoop.shaded.org.apache.hadoop.mapreduce.Mapper
     * 单词 Tokenizer 在这里翻译做分词器, 即把完整的 句子分解成 token (token 在这里就是单词)
     */
    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        // Override map function
        //重写 hadoop map-reduce 的 map 方法
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            // Tokenizing input text into words
            //StringTokenizer 是 JDK1.0 自带的分词器, 能将句子分解为单词, 已经是一个不推荐使用的类;其注释中推荐使用 String.split("\s")方法.
            /*StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                // Setting each word as the output key with a count of 1
                word.set(itr.nextToken());
                context.write(word, one);
            }*/

            // Take the place of above commented code block
            // 取代上面注释掉的 代码块
            String[] tokens = value.toString().split("\\s");
            for (String item : tokens) {
                word.set(item);
                context.write(word, one);
            }
        }
    }

    /**
     * 这个类是 map-reduce 的 Reducer 类,
     * 继承自 org.apache.hadoop.shaded.org.apache.hadoop.mapreduce.Reducer
     */
    public static class IntSumReducer
            extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        // Reduce function
        // 本例中,方法的第一个参数 key 就是文档中的一个 单词, 例如 hello,
        public void reduce(Text key, Iterable<IntWritable> values, Context context )
                throws IOException, InterruptedException {
            int sum = 0;
            // Summing up the counts for each word
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            // Emitting the final count for each word
            // 本例中,就是记录最终每个单词出现的次数, 例如 hello, 2
            System.out.println(key); //TODO: 不知道为什么,所有内从都会被输出 2 遍
            context.write(key, result);
        }
    }

    // Main method
    public static void main(String[] args) throws Exception {
        // Configuring Hadoop job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(WordCount.class);
        // Setting Mapper and Reducer classes
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        // Setting output key and value classes
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // Setting input and output paths
        // 本例中, 可以通过打印"./" 目录来发现其实际路径"
        FileInputFormat.addInputPath(job, new Path("./basic-hadoop-map-reduce/src/main/resources/hadoop_input_dir/input.txt"));
        FileOutputFormat.setOutputPath(job, new Path("./basic-hadoop-map-reduce/src/main/resources/hadoop_output_dir_" + System.currentTimeMillis() ));
        // Exiting the job based on completion status
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}