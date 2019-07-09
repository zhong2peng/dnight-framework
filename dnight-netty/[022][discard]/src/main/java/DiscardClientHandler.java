import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author ZHONGPENG769
 * @date 2019/7/8
 */
public class DiscardClientHandler extends SimpleChannelInboundHandler<Object> {

    private ByteBuf content;
    private ChannelHandlerContext ctx;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        content = ctx.alloc().directBuffer(8).writeBytes("Hello".getBytes());
        generateTraffic();
    }

    private void generateTraffic() {
        ctx.writeAndFlush(content.retain()).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    generateTraffic();
                } else {
                    future.cause().printStackTrace();
                    future.channel().closeFuture();
                }
            }
        });
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        content.release();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        DiscardUtil.printMessage((ByteBuf) msg, "Client Receive channelRead: ");
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) {
        DiscardUtil.printMessage((ByteBuf) msg, "Client Receive messageReceived: ");
    }
}
