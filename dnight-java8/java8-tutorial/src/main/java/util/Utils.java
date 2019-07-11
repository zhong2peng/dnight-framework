package util;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Utils {

    public String concat(String param1, Long param2) {
        String result = param1 + " " + param2;
        System.out.println(result);
        return result;
    }

    public static String concatStatic(String param1, Long param2) {
        String result = param1 + " " + param2;
        System.out.println(result);
        return result;
    }
}
