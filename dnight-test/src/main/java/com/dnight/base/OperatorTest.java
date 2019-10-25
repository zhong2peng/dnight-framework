package com.dnight.base;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
public class OperatorTest {
    static String x = "1";
    static int y = 1;

    public static void main(String[] args) {
        int z = 2;
        System.out.println(x + y + z);
        int i = Integer.parseInt("1024");
        int i1 = Integer.valueOf("1024").intValue();

    }
}
