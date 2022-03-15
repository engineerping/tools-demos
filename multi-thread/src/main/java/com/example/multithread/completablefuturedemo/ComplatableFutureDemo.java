package com.example.multithread.completablefuturedemo;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 假设能够提供一个服务
 * 这个服务查询各大电商网站同一类产品的截个并汇总展示
 */
public class ComplatableFutureDemo {
    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(() -> priceOfTM());
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(() -> priceOfTB());
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(() -> priceOfJD());

        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();

        end = System.currentTimeMillis();
        /*
        还可以对 priceOfTM() 的返回结果进行链式处理
        CompletableFuture.supplyAsync(() -> priceOfTM())
                .thenApply(String::valueOf)
                .thenApply(str -> "price" + str)
            .thenAccept(System.out::println);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */



        System.out.println("Use completable future spend" + (end -start));


    }


    private static double priceOfTM() {
        delay();
        return 1.0;
    }

    private static double priceOfTB() {
        delay();
        return 2.0;
    }

    private static double priceOfJD() {
        delay();
        return 3.0;
    }

    private static void delay() {
        int time0 = new SecureRandom().nextInt(500); //总时间会比较长
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep!\n", time);
    }
}
