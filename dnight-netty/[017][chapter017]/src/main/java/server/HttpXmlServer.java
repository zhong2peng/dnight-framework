package server;

import codec.HttpXmlRequestDecoder;
import codec.HttpXmlRequestEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import pojo.Order;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
public class HttpXmlServer {

    public static void main(String[] args) throws Exception {
        int port = 9090;
        new HttpXmlServer().bind(port);
    }

    public void bind(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast("HttpRequestDecoder", new HttpRequestDecoder());
                            ch.pipeline().addLast("HttpObjectAggregator", new HttpObjectAggregator(65536));
                            ch.pipeline().addLast("HttpXmlRequestDecoder", new HttpXmlRequestDecoder(Order.class, true));
                            ch.pipeline().addLast("HttpResponseEncoder", new HttpResponseEncoder());
                            ch.pipeline().addLast("HttpXmlResponseEncoder", new HttpXmlRequestEncoder());
                            ch.pipeline().addLast("HttpXmlServerHandler", new HttpXmlServerHandler());

                        }
                    });
            ChannelFuture f = b.bind(port).sync();
            System.out.println("Http订购服务器启动，网址是：" + "http://127.0.0.1:" + port);
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
