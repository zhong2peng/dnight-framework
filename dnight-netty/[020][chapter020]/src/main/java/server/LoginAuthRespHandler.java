package server;

import constant.MessageType;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import struct.Header;
import struct.NettyMessage;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter {
    private Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>();
    private String[] whitekList = {"127.0.0.1", "192.168.159.66"};

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        nodeCheck.remove(ctx.channel().remoteAddress().toString());
        ctx.close();
        ctx.fireExceptionCaught(cause);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null
                && message.getHeader().getType() == MessageType.LOGIN_REQ.value()) {
            String nodeIndex = ctx.channel().remoteAddress().toString();
            NettyMessage loginResp = null;
            if (nodeCheck.containsKey(nodeIndex)) {
                loginResp = buildResponse((byte) -1);
            } else {
                InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
                String ip = address.getAddress().getHostAddress();
                boolean isOk = false;
                for (String wip : whitekList) {
                    if (wip.equals(ip)) {
                        isOk = true;
                        break;
                    }
                }
                loginResp = isOk ? buildResponse((byte) 0) : buildResponse((byte) -1);
                if (isOk) {
                    nodeCheck.put(nodeIndex, true);
                }
            }
            System.out.println("The login response is : " + loginResp +
                    " body [" + loginResp.getBody() + "]");
            ctx.writeAndFlush(loginResp);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private NettyMessage buildResponse(byte result) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.LOGIN_RESP.value());
        message.setHeader(header);
        message.setBody(result);
        return message;
    }

}
