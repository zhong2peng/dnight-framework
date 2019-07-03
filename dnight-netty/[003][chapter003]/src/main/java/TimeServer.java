/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 9090;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
