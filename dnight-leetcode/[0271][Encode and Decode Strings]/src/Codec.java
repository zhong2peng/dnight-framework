import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Codec {

    /**
     * Design an algorithm to encode a list of strings to a string.
     * The encoded string is then sent over the network and is decoded back
     * to the original list of strings.
     * <p>
     * Implement the encode and decode methods.
     * <p>
     * Note:
     * <p>
     * The string may contain any possible characters out of 256 valid ascii characters.
     * Your algorithm should be generalized enough to work on any possible characters.
     * Do not use class member/global/static variables to store states.
     * Your encode and decode algorithms should be stateless.
     * Do not rely on any library method such as eval or serialize methods.
     * You should implement your own encode/decode algorithm.
     */

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        for (int lo = 0, i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                int len = Integer.parseInt(s.substring(lo, i));
                res.add(s.substring(i + 1, i + 1 + len));
                lo = i + 1 + len;
                i = lo;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        Codec codec = new Codec();
        String encode = codec.encode(list);
        List<String> decode = codec.decode(encode);
        for (String str : decode) {
            System.out.println(str);
        }
    }
}
