package server;

import codec.NettyMessageDecoder;
import codec.NettyMessageEncoder;
import constant.NettyConstant;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {
        new NettyServer().bind();
    }

    public void bind() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4))
                                    .addLast(new NettyMessageEncoder())
                                    .addLast("ReadTimeoutHandler", new ReadTimeoutHandler(50))
                                    .addLast(new LoginAuthRespHandler())
                                    .addLast("HeartBeatHandler", new HeartBeatRespHandler());
                        }
                    });
            b.bind(NettyConstant.REMOTE_IP, NettyConstant.PORT).sync();
            System.out.println("Netty server start ok : " + NettyConstant.REMOTE_IP + ":" + NettyConstant.PORT);
        } finally {

        }
    }
}
