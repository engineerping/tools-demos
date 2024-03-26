package com.example.anytest;

import org.springframework.boot.SpringBootVersion;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class GetSpringBootVersion {
    public static void main(String[] args) {
        String version = SpringBootVersion.getVersion();
        System.out.println(version);
    }
}
