import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZHONGPENG769
 * @date 2019/7/8
 */
public class DiscardUtil {

    private static final Logger logger = LoggerFactory.getLogger(DiscardUtil.class);

    public static void printMessage(ByteBuf byteBuf, String message) {
        ByteBuf buf = byteBuf.duplicate();
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        System.out.println(message + new String(bytes));
    }
}
