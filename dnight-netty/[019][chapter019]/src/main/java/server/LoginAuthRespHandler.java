package server;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import struct.Header;
import struct.NettyMessage;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == (byte) 1) {
            System.out.println("Login is OK");
            String body = (String) message.getBody();
            System.out.println("Received message body from client is " + body);
        }
        ctx.writeAndFlush(builidLoginResponse((byte) 3));
    }

    private NettyMessage builidLoginResponse(byte result) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte) 2);
        message.setHeader(header);
        message.setBody(result);
        return message;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
