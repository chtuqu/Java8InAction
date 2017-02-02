package com.chtuqu.ch3.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
    public static void main(String[] args) throws IOException {
        FileProcessor fp = new FileProcessor();
        String result = fp.processFile();
        String result2 = fp.processFile2(br -> br.readLine() + br.readLine());
    }

    private String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    private String processFile2(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }
}
