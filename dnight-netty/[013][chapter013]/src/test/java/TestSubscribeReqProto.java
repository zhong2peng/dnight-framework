import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import proto.SubscribeReqProto;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("dnight zp");
        builder.setProductName("Netty");
        builder.addAddress("NanJing YUhuaTai");
        builder.addAddress("ShenZhen Hongshulin");
        return builder.build();
    }

    @Test
    public void test() throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : \n" + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode : \n" + req2.toString());
        System.out.println("Assert equal : -> " + req2.equals(req));
    }
}
