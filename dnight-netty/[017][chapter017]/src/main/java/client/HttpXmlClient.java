package client;

import codec.HttpXmlRequestEncoder;
import codec.HttpXmlResponseDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import pojo.Order;

import java.net.InetSocketAddress;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
public class HttpXmlClient {

    public static void main(String[] args) throws Exception {
        int port = 9090;
        new HttpXmlClient().connect(port);
    }

    public void connect(int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast("HttpResponseDecoder", new HttpResponseDecoder());
                            ch.pipeline().addLast("HttpObjectAggregator", new HttpObjectAggregator(65536));
                            ch.pipeline().addLast("HttpXmlResponseDecoder", new HttpXmlResponseDecoder(Order.class, true));
                            ch.pipeline().addLast("HttpRequestEncoder", new HttpRequestEncoder());
                            ch.pipeline().addLast("HttpXmlRequestEncoder", new HttpXmlRequestEncoder());
                            ch.pipeline().addLast("HttpXmlClientHandle", new HttpXmlClientHandle());

                        }
                    });
            ChannelFuture f = b.connect(new InetSocketAddress(port)).sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
