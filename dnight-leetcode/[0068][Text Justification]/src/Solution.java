import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Solution {

    /**
     * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
     * <p>
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
     * <p>
     * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
     * <p>
     * For the last line of text, it should be left justified and no extra space is inserted between words.
     * <p>
     * Note:
     * <p>
     * A word is defined as a character sequence consisting of non-space characters only.
     * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
     * The input array words contains at least one word.
     * <p>
     * 一个句子，和一个长度表示一行最长的长度，然后对齐文本，有下边几个规则。
     * <p>
     * 同一个单词只能出现在一行中，不能拆分
     * 一行如果只能放下一个单词，该单词放在最左边，然后空格补齐，例如 "acknowledgement#####"，这里只是我为了直观，# 表示空格，题目并没有要求。
     * 一行如果有多个单词，最左边和最右边不能有空格，每个单词间隙尽量平均，如果无法平均，把剩余的空隙从左边开始分配。例如，"enough###to###explain##to"，3 个间隙，每个 2 个空格的话，剩下 2 个空格，从左边依次添加一个空格。
     * 最后一行执行左对齐，单词间一个空格，末尾用空格补齐。
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int count = 0, last = 0;
        for (int i = 0; i < words.length; i++) {
            if (count + words[i].length() + (i - last) > maxWidth) {
                int spaceNum = 0, extraNum = 0;
                if (i - last - 1 > 0) {
                    spaceNum = (maxWidth - count) / (i - last - 1);
                    extraNum = (maxWidth - count) % (i - last - 1);
                }
                StringBuilder str = new StringBuilder();
                for (int j = last; j < i; j++) {
                    str.append(words[j]);
                    if (j < i - 1) {
                        for (int k = 0; k < spaceNum; k++) {
                            str.append(" ");
                        }
                        if (extraNum > 0) {
                            str.append(" ");
                        }
                        extraNum--;
                    }
                }
                for (int j = str.length(); j < maxWidth; j++) {
                    str.append(" ");
                }
                res.add(str.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }
        StringBuilder str = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            str.append(words[i]);
            if (str.length() < maxWidth) {
                str.append(" ");
            }
        }
        for (int i = str.length(); i < maxWidth; i++) {
            str.append(" ");
        }
        res.add(str.toString());
        return res;
    }
}
