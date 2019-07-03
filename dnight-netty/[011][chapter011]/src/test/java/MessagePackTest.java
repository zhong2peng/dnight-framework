import com.google.gson.Gson;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class MessagePackTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessagePackTest.class);

    @Test
    public void testMessagePack_decodeAndEncode() throws Exception {
        MessageInfo src = new MessageInfo(1, "message", 1.1);
        LOGGER.info(src.toString());
        MessagePack msgpack = new MessagePack();
        //序列化
        byte[] bytes = msgpack.write(src);
        //反序列化
        MessageInfo dst = msgpack.read(bytes, MessageInfo.class);
        LOGGER.info(dst.toString());
        Gson gson = new Gson();
        JSONAssert.assertEquals(gson.toJson(src), gson.toJson(dst), false);
    }


}
