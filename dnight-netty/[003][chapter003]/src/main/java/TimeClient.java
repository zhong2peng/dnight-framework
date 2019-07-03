/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 9090;
        new Thread(new TimeClientHandler("127.0.0.1", port), "TimeClient-001").start();
    }
}
