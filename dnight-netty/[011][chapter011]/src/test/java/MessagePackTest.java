import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.MessageTypeException;
import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;
import org.msgpack.type.Value;
import org.msgpack.unpacker.Converter;
import org.msgpack.unpacker.Unpacker;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testMessagePack_multiInstance() throws Exception {
        final int number = 3;
        List<MessageInfo> src = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            src.add(new MessageInfo(i, "message" + i, i * 1.1));
        }
        MessagePack msgpack = new MessagePack();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Packer packer = msgpack.createPacker(out);
        for (MessageInfo info : src) {
            packer.write(info);
        }
        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Unpacker unpacker = msgpack.createUnpacker(in);
        List<MessageInfo> dst = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            dst.add(unpacker.read(MessageInfo.class));
        }
        LOGGER.info(src.toString());
        LOGGER.info(dst.toString());
        Gson gson = new Gson();
        JSONAssert.assertEquals(gson.toJson(src), gson.toJson(dst), false);
    }

    @Test
    public void testMessagePack_multiDataType() throws Exception {
        MessagePack msgpack = new MessagePack();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Packer packer = msgpack.createPacker(out);
        boolean trueValue = true;
        int intValue = 10;
        double doubleValue = 10.5;
        packer.write(trueValue);
        packer.write(intValue);
        packer.write(doubleValue);

        boolean trueWrapValue = Boolean.TRUE;
        Integer intWrapValue = new Integer(10);
        Double doubleWrapValue = new Double(10.5);
        packer.write(trueWrapValue);
        packer.write(intWrapValue);
        packer.write(doubleWrapValue);

        int[] intArray = new int[]{1, 2, 3, 4};
        Double[] doubleWrapArray = new Double[]{10.5, 20.5};
        String[] stringArray = new String[]{"msg", "pack", "for", "java"};
        byte[] byteArray = new byte[]{0x30, 0x31, 0x32};
        packer.write(intArray);
        packer.write(doubleWrapArray);
        packer.write(stringArray);
        packer.write(byteArray);

        String string = "MessagePack";
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{0x30, 0x31, 0x32});
        BigInteger bigInteger = BigInteger.ONE;
        packer.write(string);
        packer.write(byteBuffer);
        packer.write(bigInteger);

        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Unpacker unpacker = msgpack.createUnpacker(in);

        boolean b = unpacker.readBoolean();
        LOGGER.info(trueValue + "");
        LOGGER.info(b + "");
        Assert.assertEquals(trueValue, b);

        int i = unpacker.readInt();
        LOGGER.info(intValue + "");
        LOGGER.info(i + "");
        Assert.assertEquals(intValue, i);

        double d = unpacker.readDouble();
        LOGGER.info(doubleValue + "");
        LOGGER.info(d + "");
        Assert.assertEquals(doubleValue, d, 0);

        Boolean wb = unpacker.read(Boolean.class);
        LOGGER.info(trueWrapValue + "");
        LOGGER.info(wb + "");
        Assert.assertEquals(trueWrapValue, wb);

        Integer wi = unpacker.read(Integer.class);
        LOGGER.info(intWrapValue + "");
        LOGGER.info(wi + "");
        Assert.assertEquals(intWrapValue, wi);

        Double wd = unpacker.read(Double.class);
        LOGGER.info(doubleWrapValue + "");
        LOGGER.info(wd + "");
        Assert.assertEquals(doubleWrapValue, wd);

        int[] ia = unpacker.read(int[].class);
        LOGGER.info(new Gson().toJson(intArray));
        LOGGER.info(new Gson().toJson(ia));
        Assert.assertArrayEquals(intArray, ia);

        Double[] da = unpacker.read(Double[].class);
        LOGGER.info(new Gson().toJson(doubleWrapArray));
        LOGGER.info(new Gson().toJson(da));
        Assert.assertArrayEquals(doubleWrapArray, da);

        String[] sa = unpacker.read(String[].class);
        LOGGER.info(new Gson().toJson(stringArray));
        LOGGER.info(new Gson().toJson(sa));
        Assert.assertArrayEquals(stringArray, sa);

        byte[] ba = unpacker.read(byte[].class);
        LOGGER.info(new Gson().toJson(byteArray));
        LOGGER.info(new Gson().toJson(ba));
        Assert.assertArrayEquals(byteArray, ba);

        String ws = unpacker.read(String.class);
        LOGGER.info(new Gson().toJson(string));
        LOGGER.info(new Gson().toJson(ws));
        Assert.assertEquals(string, ws);

        ByteBuffer buf = unpacker.read(ByteBuffer.class);
        LOGGER.info(new Gson().toJson(byteBuffer));
        LOGGER.info(new Gson().toJson(buf));
        Assert.assertEquals(byteBuffer, buf);

        BigInteger bi = unpacker.read(BigInteger.class);
        LOGGER.info(new Gson().toJson(bigInteger));
        LOGGER.info(new Gson().toJson(bi));
        Assert.assertEquals(bigInteger, bi);
    }

    @Test
    public void testMessagePack_ListAndMap() throws Exception {
        MessagePack msgpack = new MessagePack();
        Template<List<String>> listTmpl = Templates.tList(Templates.TString);
        Template<Map<String, String>> mapTmpl = Templates.tMap(Templates.TString, Templates.TString);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Packer packer = msgpack.createPacker(out);

        List<String> srcList = new ArrayList<>();
        srcList.add("msgpack");
        srcList.add("for");
        srcList.add("java");
        packer.write(srcList);

        Map<String, String> srcMap = new HashMap<>();
        srcMap.put("sadayuki", "fffsrs");
        srcMap.put("muga", "nishizawa");
        packer.write(srcMap);

        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Unpacker unpacker = msgpack.createUnpacker(in);

        List<String> dstList = unpacker.read(listTmpl);
        String s1 = new Gson().toJson(srcList);
        String s2 = new Gson().toJson(dstList);
        LOGGER.info(s1);
        LOGGER.info(s2);
        JSONAssert.assertEquals(s1, s2, false);

        Map<String, String> dstMap = unpacker.read(mapTmpl);
        s1 = new Gson().toJson(srcMap);
        s2 = new Gson().toJson(dstMap);
        LOGGER.info(s1);
        LOGGER.info(s2);
        JSONAssert.assertEquals(s1, s2, false);
    }

    @Test(expected = MessageTypeException.class)
    public void testMessagePack_withoutMessageAnnotation() throws Exception {
        MessageInfo2 src = new MessageInfo2(1, "message", 1.1);
        LOGGER.info(src.toString());
        MessagePack msgPack = new MessagePack();

        byte[] bytes = msgPack.write(src);
        MessageInfo2 dst = msgPack.read(bytes, MessageInfo2.class);
        LOGGER.info(dst.toString());
        JSONAssert.assertEquals(new Gson().toJson(src), new Gson().toJson(dst), false);
    }

    @Test
    public void testMessagePack_dynamic() throws Exception {
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("bisd");

        MessagePack msgpack = new MessagePack();
        byte[] raw = msgpack.write(src);

        List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
        String s1 = new Gson().toJson(src);
        String s2 = new Gson().toJson(dst1);
        LOGGER.info(s1);
        LOGGER.info(s2);
        JSONAssert.assertEquals(s1, s2, false);

        Value dynamic = msgpack.read(raw);
        LOGGER.info(dynamic.isArrayValue() + "");
        LOGGER.info(dynamic.asArrayValue().get(0).getClass() + "");
        List<String> dst2 = new Converter(dynamic).read(Templates.tList(Templates.TString));
        s1 = new Gson().toJson(src);
        s2 = new Gson().toJson(dst2);
        LOGGER.info(s1);
        LOGGER.info(s2);
        JSONAssert.assertEquals(s1, s2, false);
    }

}
