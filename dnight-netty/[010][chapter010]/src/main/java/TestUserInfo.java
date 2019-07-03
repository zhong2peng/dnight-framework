import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author ZHONGPENG769
 * @date 2019/7/3
 */
public class TestUserInfo {

    public static void main(String[] args) throws Exception {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUserName("Welcome To Netty.");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable lenght is : " + b.length);
        bos.close();
        System.out.println("-----------------------------------------");
        System.out.println("The byte array serializable length is : " + info.codeC().length);
    }
}
