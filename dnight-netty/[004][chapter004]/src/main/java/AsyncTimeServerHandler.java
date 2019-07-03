import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;
    private CountDownLatch latch;
    private AsynchronousServerSocketChannel channel;

    AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public AsynchronousServerSocketChannel getChannel() {
        return channel;
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doAccept() {
        channel.accept(this, new AcceptCompletionHandler());
    }
}
