/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Solution {

    /**
     * 给定一个字符串S和T，找出S中包含T所有字符的最小子串。
     * <p>
     * 采用滑动窗口，窗口有左右边界，先通过扩展右边界找出一个包含T中所有字符的子串，然后收缩左边界，直到不能再收缩。记录此时的子串。然后收缩左边界，继续扩展右边界，直到再找到满足要求的子串，和上次的进行比较，保存更小的子串。
     * 返回执行，直到右边界到达S串尾，且左边界不能再收缩。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] count = new int['z' - 'A' + 1];
        int uniq = 0;
        for (int i = 0; i < t.length(); i++) {
            if (++count[t.charAt(i) - 'A'] == 1) {
                uniq++;
            }
        }
        // r右窗口边界，l左窗口边界
        int found = 0, r = 0, l = 0;
        int minLen = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;
        while (found < uniq) {
            //移动右边界
            while (r < s.length()) {
                if (found >= uniq) break;
                if (--count[s.charAt(r) - 'A'] == 0) found++;
                r++;
            }
            //必须找到，否则不存在
            if (found < uniq) break;
            //移动左窗口
            while (l < r && count[s.charAt(l) - 'A'] < 0)
                count[s.charAt(l++) - 'A']++;
            //更新左右窗口边界
            if (r - l < minLen) {
                minLen = r - l;
                minJ = l;
            }
            //最左侧初始化
            count[s.charAt(l++) - 'A']++;
            //再次更新
            found--;
        }
        return minLen < Integer.MAX_VALUE ? s.substring(minJ, minJ + minLen) : "";
    }
}
