package com.burning8393.adaptor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("f:/mashibing/docs/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
