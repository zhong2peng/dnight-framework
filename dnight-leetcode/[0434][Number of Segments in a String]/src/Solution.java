/**
 * @author ZHONGPENG769
 * @date 2019/10/29
 */
public class Solution {

    /**
     * Count the number of segments in a string,
     * where a segment is defined to be a contiguous sequence of non-space characters.
     * <p>
     * <p>
     * Please note that the string does not contain any non-printable characters.
     * <p>
     * Example:
     * <p>
     * Input: "Hello, my name is John"
     * Output: 5
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        String[] s1 = s.split(" ");
        int size = 0;
        for (String str : s1) {
            if (str.trim().isEmpty()) {
                continue;
            }
            size++;
        }
        return size;
    }

    public int countSegments1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        return res;
    }
}
