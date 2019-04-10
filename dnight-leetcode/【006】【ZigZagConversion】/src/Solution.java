public class Solution {

    /***
     *
     * <pre>
     *     原题
     * The string “PAYPALISHIRING” is written in a zigzag pattern on a given number
     * of rows like this: (you may want to display this pattern in a fixed font for
     * better legibility)
     * 　　P A H N
     * 　　APLSIIG
     * 　　Y I R
     * And then read line by line: “PAHNAPLSIIGYIR”
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string text, int nRows);
     * convert(“PAYPALISHIRING”,3) should return “PAHNAPLSIIGYIR”.
     * 题目大意
     * 输入一个字符串和指定的行数，将字符以Z字型输出。
     *
     * 解题思路
     * 计算出字符的最大列数，根据列数和行数创建一个一维数组，再计算每个字符中一维数组中的位置，
     * 再对一维数组中的字符进行紧凑操作，返回结果。
     * </pre>
     *
     * @param s
     * @param nRows
     * @return
     */
    public String convert(String s, int nRows){
        if (s == null || s.length() <= nRows || nRows == 1){
            return s;
        }
        int index = s.length();
        int rowLength = 0;
        int slash = nRows - 2;

        while (index > 0){
            index -= nRows;
            rowLength++;
            for (int i=0; i<slash && index >0; i++){
                rowLength++;
                index--;
            }
        }

        char[] result = new char[nRows * rowLength];
        for (int i = 0; i< result.length; i++){
            result[i] = ' ';
        }
        int curColumn = 0;
        index = 0;
        while (index < s.length()){
            for (int i = 0; i<nRows && index < s.length(); i++){
                result[rowLength * i + curColumn] = s.charAt(index);
                index++;
            }
            curColumn++;
            for (int i = nRows - 2; i>0&&index<s.length();i--){
                result[rowLength * i + curColumn] = s.charAt(index);
                curColumn++;
                index++;
            }
        }
        index = 0;
        while (index < s.length() && result[index] != ' '){
            index++;
        }
        int next = index + 1;
        while (index < s.length()){
            while (next < result.length && result[next] == ' '){
                next++;
            }
            result[index] = result[next];
            index++;
            next++;
        }
        return new String(result, 0, index);
    }

  public static void main(String[] args) {
    System.out.println(new Solution().convert("PAYPALISHIRING", 3));
  }
}
