import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
    private final int sendNumber;

    public EchoClientHandler() {
        this(0);
    }

    public EchoClientHandler(int sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        UserInfo[] infos = toUserInfo();
        for (UserInfo info : infos) {
            ctx.write(info);
        }
        ctx.flush();
    }

    private UserInfo[] toUserInfo() {
        UserInfo[] userInfos = new UserInfo[sendNumber];
        UserInfo userInfo;
        for (int i = 0; i < sendNumber; i++) {
            userInfo = new UserInfo();
            userInfo.setUserId(i);
            userInfo.setAge(i + 10);
            userInfo.setUserName("ABCDEFG ---> " + i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Client receive the msgpack message :" + msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
