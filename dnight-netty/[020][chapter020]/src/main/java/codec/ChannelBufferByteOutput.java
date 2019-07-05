package codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

import java.io.IOException;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class ChannelBufferByteOutput implements ByteOutput {

    private final ByteBuf buffer;

    public ChannelBufferByteOutput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public void write(int b) {
        buffer.writeByte(b);
    }

    @Override
    public void write(byte[] b) {
        buffer.writeBytes(b);
    }

    @Override
    public void write(byte[] b, int off, int len) {
        buffer.writeBytes(b, off, len);
    }

    @Override
    public void close() {

    }

    @Override
    public void flush() {

    }

    public ByteBuf getBuffer() {
        return buffer;
    }
}
