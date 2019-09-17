package com.dnight.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        );
        PrintWriter out = new PrintWriter(System.out, true);
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            out.println(s);
        }
    }
}
