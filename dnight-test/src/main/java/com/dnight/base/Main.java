package com.dnight.base;

import java.util.Scanner;

/**
 * @author ZHONGPENG769
 * @date 2019/10/30
 */
public class Main {

    public void test1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            if (input == null || input.length() == 0) {
                continue;
            }
            char last = input.charAt(0);
            int max = Integer.MIN_VALUE;
            int current = 1;
            char res = last;
            for (int i = 1, len = input.length(); i < len; i++) {
                if (last == input.charAt(i)) {
                    current++;
                } else {
                    if (max < current || (max == current && res - last < 0)) {
                        max = current;
                        res = last;
                    }
                    current = 1;
                    last = input.charAt(i);
                }
            }
            StringBuilder sb = new StringBuilder(res);
            while (current >= 0) {
                sb.append(res);
                current--;
            }
            System.out.println(sb.toString());

        }
    }

    public static String output(String input) {
        char last = input.charAt(0);
        int current = 1;

        char res = last;
        int max = 1;
        boolean flag = true;
        for (int i = 1, len = input.length(); i < len; i++) {
            if (last == input.charAt(i)) {
                current++;

            } else {
                if (max < current) {
                    max = current;
                    res = last;
                } else if (max == current && res - last > 0) {
                    res = last;
                } else if (max == current && res == last && input.charAt(i) - last < 0) {
                    res = input.charAt(i);
                }
                flag = false;
                current = 1;
                last = input.charAt(i);
            }

        }
        if (flag) {
            max = input.length();
        }
        if (current == max && res - last > 0) {
            res = input.charAt(input.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (max > 0) {
            sb.append(res);
            max--;
        }

//        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String input0 = "xa";
        String input01 = "xxaaccddddeeee";
        String input1 = "aaabbbbbccccccccczzzzzzzzz";
        String input2 = "aa";
        String input3 = "xxaabb";
        String input4 = "xba";
        String input5 = "xxbbaa";
        System.out.println(output(input01));
        System.out.println(output(input0));
        System.out.println(output(input1));
        System.out.println(output(input2));
        System.out.println(output(input3));
        System.out.println(output(input4));
        System.out.println(output(input5));


    }
}
