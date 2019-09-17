/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution extends Reader4 {

    /**
     * The API: int read4(char *buf) reads 4 characters at a time from a file.
     * <p>
     * The return value is the actual number of characters read. For example,
     * it returns 3 if there is only 3 characters left in the file.
     * <p>
     * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
     * <p>
     * Note:
     * The read function will only be called once for each test case.
     * <p>
     * 现在要从文件里面读n个字符串，可以用的API只有read4
     * int read4(char[] buf);
     * <p>
     * 解题思路分析
     * 基本步骤就是可以分成几种情况，
     * 第一是读的过程中遇到文件结束了， 这个需要判断每次返回的字符个数是不是<4
     * 第一是可以完整的读入4个字符的， 总共可以读n/4次
     * 第二是最后多出来的几个字符， n%4
     * <p>
     * 整体可以分成两步
     *
     * @param buf
     * @return
     */
    int read4(char[] buf, int n) {
        int total = 0;
        char[] temp = new char[4];
        for (int i = 0; i < n / 4; ++i) {
            int count = read4(temp);
            System.arraycopy(temp, 0, buf, total, count);
            total += count;
            if (count < 4) {
                return total;
            }
        }
        if (n % 4 > 0) {
            int remain = n % 4;
            int count = read4(temp);
            count = Math.min(count, remain);
            System.arraycopy(temp, 0, buf, total, count);
            total += count;
        }
        return total;
    }
}
