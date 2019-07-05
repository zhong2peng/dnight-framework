package codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

import java.io.IOException;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class ChannelBufferByteInput implements ByteInput {

    private final ByteBuf buffer;

    public ChannelBufferByteInput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public int read() {
        if (buffer.isReadable()) {
            return buffer.readByte() & 0xff;
        }
        return -1;
    }

    @Override
    public int read(byte[] array) throws IOException {
        return read(array, 0, array.length);
    }

    @Override
    public int read(byte[] dst, int dstIndex, int len) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        len = Math.min(available, len);
        buffer.readBytes(dst, dstIndex, len);
        return len;
    }

    @Override
    public int available() {
        return buffer.readableBytes();
    }

    @Override
    public long skip(long bytes) {
        int readable = buffer.readableBytes();
        if (readable < bytes) {
            bytes = readable;
        }
        buffer.readerIndex((int) (buffer.readerIndex() + bytes));
        return bytes;
    }

    @Override
    public void close() {

    }
}
