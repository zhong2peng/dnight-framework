package codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class NettyMarshallingEncoder extends MarshallingEncoder {

    /**
     * Creates a new encoder.
     *
     * @param provider the {@link MarshallerProvider} to use
     */
    public NettyMarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        super.encode(ctx, msg, out);
    }
}
