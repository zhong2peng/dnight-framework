/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 9090;
        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
