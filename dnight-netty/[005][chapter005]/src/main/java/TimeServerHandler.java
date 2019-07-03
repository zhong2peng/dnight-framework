import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 类型转换，将msg 转换成Netty 的ByteBuf 对象。ByteBuf 类似于JDK 中的
        // java.nio.ByteBuffer 对象，不过它提供了更加强大和灵前的功能。通过ByteBuf 的
        // readableBytes 方法可以获取缓冲区可读的字节数，根据可读的字节数创建byte 数组，通过
        // ByteBuf 的readBytes 方法将缓冲区中的字节数组复制到新建的byte 数组中，最后通过new
        // String 构造函数获取请求消息。这时对请求消息进行判断， 如果是”QUERY TIME ORDER”
        // 则创建应答消息，通过ChannelHandlerContext 的write 方法异步发送应答消息给客户端。
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8);
        System.out.println("The time server receive order : " + body);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
                ? new Date(System.currentTimeMillis()).toString()
                : "BAD ORDER";
        ByteBuf resq = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resq);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 将消息发送队列中的消息写入到SocketChannel中发送给对方。从性能角度考虑， 为了防止频繁
        // 地唤醒Selector 进行消息发迭， Netty 的write 方法并不直接将消息写入SocketChannel 中，
        // 调用write 方法只是把待发迭的消息放到发送缓冲数组中， 再通过调用flush 方法，将发送
        // 缓冲区中的消息全部写到SocketChannel 中。
        ctx.flush();
    }
}
