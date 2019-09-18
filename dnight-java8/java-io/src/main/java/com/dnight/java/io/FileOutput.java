package com.dnight.java.io;

import java.io.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class FileOutput {

    public static void basic(String infile, String outfile) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read(infile)
        ));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(outfile)
        ));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(outfile));
    }

    public static void shortcut(String infile, String outfile) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(infile)
                )
        );
        PrintWriter out = new PrintWriter(outfile);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(outfile));
    }

    public static void main(String[] args) throws IOException {
        String parent = FileOutput.class.getResource("/").getPath();
        String infile = parent + "/infile.txt";
        String outfile = parent + "/BasicOut.txt";
        basic(infile, outfile);

        outfile = parent + "ShortcutOut";
        shortcut(infile, outfile);
    }


}
