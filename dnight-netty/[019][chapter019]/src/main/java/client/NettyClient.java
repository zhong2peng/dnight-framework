package client;

import codec.NettyMessageDecoder;
import codec.NettyMessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class NettyClient {

    public static void main(String[] args) throws Exception {
        new NettyClient().connect("127.0.0.1", 9090);
    }

    public void connect(String remoteServer, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4, -8, 0))
                                    .addLast(new NettyMessageEncoder())
                                    .addLast(new LoginAuthReqHandler());
                        }
                    });
            ChannelFuture f = b.connect(remoteServer, port).sync();
            System.out.println("Netty time Client connected at port " + port);
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
