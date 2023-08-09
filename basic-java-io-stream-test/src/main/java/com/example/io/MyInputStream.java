package com.example.io;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class MyInputStream {
    public static File createFile(String URI, String content, boolean append) throws URISyntaxException, InterruptedException, IOException {
        URI uri = new URI("D:/temp/MyFile1.txt");
        File file = new File(uri);
        byte[] buffer = new byte[4]; //4 Byte is 1 block // not required

        FileWriter fileWriter = new FileWriter(file, append);
        fileWriter.write("abcd");

        FileReader fileReader = new FileReader(file);
        fileReader.read();
        FileInputStream inputStream = new FileInputStream(file);
        inputStream.read(buffer);
        int read = -1;
        while ((read = inputStream.read()) > 0) {

            inputStream.read();
        }
        System.out.println();

        return file;
    }
}
