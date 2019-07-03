/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 9090;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),
                "AIO-AsyncTimeClientHandler-001").start();
    }
}
