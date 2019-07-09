import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author ZHONGPENG769
 * @date 2019/7/8
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private final ByteBuf firstMessage;
    private final static String S = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public EchoClientHandler() {
        firstMessage = Unpooled.buffer(EchoClient.SIZE);
        for (int i = 0; i < firstMessage.capacity(); i++) {
            firstMessage.writeByte((byte) (S.charAt((int) (Math.random() * S.length()))));
            System.out.println((S.charAt((int) (Math.random() * S.length()))));
        }
        System.out.println("+++++++++++");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        EchoUtil.printMessage(firstMessage, "Client begin to write message: ");
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof ByteBuf) {
            EchoUtil.printMessage((ByteBuf) msg, "Client read message: ");
        }
//        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        System.out.println("Client read complete");
        ctx.flush();
    }
}
