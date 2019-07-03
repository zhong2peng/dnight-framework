import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class TimeClient {

    public static void main(String[] args) throws Exception {
        int port = 9090;
        new TimeClient().connect(port, "127.0.0.1");
    }

    public void connect(int port, String host) throws Exception {
        // 配置客户端NIO线程组
        // 创建客户端处理IO读写的NioEventLoopGroup 线程组，然后继续创建客户端
        // 辅助启动类Bootstrap ， 随后需要对其进行配置。
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            // Channel 需要设置为NioSocketChannel，然后为其添加Handler。此处
            // 为了简单直接创建匿名内部类， 实现initChannel 方法，其作用是当创建NioSocketChannel
            // 成功之后，在进行初始化时，将它的ChannelHandler 设置到ChannelPipeline 中，用于处理
            // 网络IO事件。
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new TimeClientHandler());
                        }

                    });

            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}
