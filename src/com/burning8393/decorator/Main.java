package com.burning8393.decorator;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("F:\\mashibing\\docs\\test.txt");
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("http://www.burning8393.com");
        bw.flush();
        bw.close();
    }
}
