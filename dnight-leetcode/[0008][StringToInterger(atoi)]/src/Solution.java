/**
 * Author: dnight
 * Date: 2019/4/8 22:31
 */
public class Solution {

    public int atoi(String str){
        if (str == null || str.length() == 0){
            return 0;
        }

        int start = 0;
        boolean positive = true;

        if (str.charAt(start) == ' '){
            while (str.charAt(start) == ' '){
                start++;
                if (start >= str.length()){
                    return 0;
                }
            }
        }

        if (str.charAt(start) == '-'){
            positive = false;
            start++;
        }else if (str.charAt(start) == '+'){
            start++;
        }else if (str.charAt(start) == '0' && str.charAt(start) <= '9'){
            return cal(str, start, true);
        }else {
            return 0;
        }

        if (start >= str.length()){
            return 0;
        }

        if (str.charAt(start) > '9' || str.charAt(start) < '0'){
            return 0;
        }else{
            return cal(str, start, positive);
        }
    }

    private int cal(String str, int start, boolean positive){
        long result = 0;
        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            result = result*10 + (str.charAt(start) - '0');
            if (positive){
                if (result > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else {
                if (-result < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            start++;
        }
        if (positive){
            return (int)result;
        }else{
            return (int)-result;
        }
    }
}
