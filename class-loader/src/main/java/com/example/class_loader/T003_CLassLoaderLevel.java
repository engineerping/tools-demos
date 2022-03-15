package com.example.class_loader;

public class T003_CLassLoaderLevel {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println("pathBoot----\n" + pathBoot.replaceAll(";", System.lineSeparator()));

        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println("pathExt----\n" + pathExt.replaceAll(";", System.lineSeparator()));

        String pathApp = System.getProperty("java.class.path");
        System.out.println("pathApp----\n" + pathApp.replaceAll(";", System.lineSeparator()));
    }
}
