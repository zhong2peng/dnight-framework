/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Trier {

    Trier[] children;
    char c;
    boolean flag;

    public Trier() {
        children = new Trier[26];
        flag = false;
    }
}
