package client;

import constant.MessageType;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import struct.Header;
import struct.NettyMessage;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class HeartbeatReqHandler extends ChannelHandlerAdapter {

    private volatile ScheduledFuture<?> heartBeat;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        if (heartBeat != null) {
            heartBeat.cancel(true);
            heartBeat = null;
        }
        ctx.fireExceptionCaught(cause);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null
                && message.getHeader().getType() == MessageType.LOGIN_RESP.value()) {
            heartBeat = ctx.executor().scheduleAtFixedRate(
                    new HeartBeatTask(ctx), 0, 5000,
                    TimeUnit.MILLISECONDS
            );
        } else if (message.getHeader() != null
                && message.getHeader().getType() == MessageType.HEATBEAT_RESP.value()) {
            System.out.println("Client receive heart beat message : ---> " + message);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private class HeartBeatTask implements Runnable {

        private final ChannelHandlerContext ctx;

        public HeartBeatTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            NettyMessage heatBeat = buildHeatBeat();
            System.out.println("Client send heart beat message to server : --> " + heatBeat);
            ctx.writeAndFlush(heatBeat);
        }

        private NettyMessage buildHeatBeat() {
            NettyMessage message = new NettyMessage();
            Header header = new Header();
            header.setType(MessageType.HEARTBEAT_REQ.value());
            message.setHeader(header);
            return message;
        }
    }
}
