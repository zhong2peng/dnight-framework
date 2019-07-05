package client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import struct.Header;
import struct.NettyMessage;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class LoginAuthReqHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(buildLoginReq());
    }

    private NettyMessage buildLoginReq() {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte) 1);
        message.setHeader(header);
        message.setBody("It is request");
        return message;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == (byte) 2) {
            System.out.println("Received from server response");
        }
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
