package com.example.io;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class MyReader {
    public static File createFile(String URI, String content) throws URISyntaxException {
        java.net.URI uri = new URI("D:/temp/MyFile1.txt");
        File file = new File(uri);

        Writer writer = new BufferedWriter(new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {

            }

            @Override
            public void flush() throws IOException {

            }

            @Override
            public void close() throws IOException {

            }
        });

        return file;
    }
}
