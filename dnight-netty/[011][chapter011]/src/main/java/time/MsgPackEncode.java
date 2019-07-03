package time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class MsgPackEncode extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        MessagePack msgPack = new MessagePack();
        System.out.println(msg.getClass());
        byte[] raw = null;
        raw = msgPack.write(msg);
        out.writeBytes(raw);
    }
}
