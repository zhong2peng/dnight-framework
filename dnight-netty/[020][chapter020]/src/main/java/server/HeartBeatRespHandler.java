package server;

import constant.MessageType;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import struct.Header;
import struct.NettyMessage;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class HeartBeatRespHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null
                && message.getHeader().getType() == MessageType.HEARTBEAT_REQ.value()) {
            System.out.println("Receive client heart beat message : ---> " + message);
            NettyMessage heartBeat = buildHeartBeat();
            System.out.println("Send heart beat response message to client : ---> " + heartBeat);
            ctx.writeAndFlush(heartBeat);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private NettyMessage buildHeartBeat() {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.HEATBEAT_RESP.value());
        message.setHeader(header);
        return message;
    }
}
