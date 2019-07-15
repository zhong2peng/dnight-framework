/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100"
     *
     * 题目大意
     * 给定两个二进制的字符串，返回它们的和，也是二进行制字符串。
     *
     * 解题思路
     * 先将对应的两个二进制字符串转换成对应的整数数组，从低位到高位进行相加，同时要考虑到最后
     * 相加还要扩展一位的情况。详情请见代码实现。
     * </pre>
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int[] ca = new int[a.length()];
        int[] cb = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            ca[i] = a.charAt(i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            cb[i] = b.charAt(i) - '0';
        }

        if (ca.length < cb.length) {
            int[] tmp = ca;
            ca = cb;
            cb = tmp;
        }

        int ai = ca.length - 1;
        int bi = cb.length - 1;
        int carray = 0;
        int result;

        // 计算比如：1010101101 + 10100
        while (ai >= 0 && bi >= 0) {
            result = ca[ai] + cb[bi] + carray;
            ca[ai] = result % 2;
            carray = result / 2;
            ai--;
            bi--;
        }

        while (ai >= 0) {
            result = ca[ai] + carray;
            ca[ai] = result % 2;
            carray = result / 2;
            if (carray == 0) {
                break;
            }
            ai--;
        }
        for (int i = 0; i < ca.length; i++) {
            ca[i] += '0';
        }
        if (carray == 0) {
            char[] ch = new char[ca.length];
            for (int i = 0; i < ca.length; i++) {
                ch[i] = (char) ca[i];
            }
            return new String(ch);
        } else {
            char[] ch = new char[ca.length + 1];
            ch[0] = '1';
            for (int i = 0; i < ca.length; i++) {
                ch[i + 1] = (char) ca[i];
            }
            return new String(ch);
        }
    }
}
