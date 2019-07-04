package client;

import codec.HttpXmlRequest;
import codec.HttpXmlResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import pojo.OrderFactory;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
public class HttpXmlClientHandle extends SimpleChannelInboundHandler<HttpXmlResponse> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        HttpXmlRequest request = new HttpXmlRequest(null, OrderFactory.create(123));
        ctx.writeAndFlush(request);
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpXmlResponse msg) {
        System.out.println("The client receice response of http header is : " + msg.getHttpResponse().headers().names());
        System.out.println("The client receive response of http body is :" + msg.getResult());
    }
}
