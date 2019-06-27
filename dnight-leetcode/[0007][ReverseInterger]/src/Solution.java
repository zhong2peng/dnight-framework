/**
 * Author: dnight
 * Date: 2019/4/8 22:23
 *
 */
public class Solution {

  /**
   * *
   *
   * <pre>
   * 原题
   * Reverse digits of an integer.
   * Example1: x = 123, return 321
   * Example2: x = -123, return -321
   *
   * 题目大意
   * 输入一个整数对其进行翻转
   *
   * 解题思路
   * 通过求余数求商法进行操作。
   * </pre>
   *
   * @param x
   * @return
   */
  public int reverse(int x) {
    long tmp = x;
    long result = 0;

    while (tmp != 0) {
      result = result * 10 + tmp % 10;
      tmp = tmp / 10;
    }

    if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
      result = 0;
    }

    return (int) result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reverse(1234));
  }
}
