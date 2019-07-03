package time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class TimeClient {

    private final static int PORT = 28080;
    private final String HOST = "127.0.0.1";
    private final static EventLoopGroup GROUP = new NioEventLoopGroup();

    public void createBootstrap(Bootstrap b, EventLoopGroup group) {
        b.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new MsgPackDecode());
                        pipeline.addLast(new MsgPackEncode());
                        pipeline.addLast(new TimeClientHandler());
                    }
                });
        try {
            ChannelFuture f = b.connect(HOST, PORT).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
