package codec;

import io.netty.handler.codec.http.FullHttpResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHONGPENG769
 * @date 2019/7/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpXmlResponse {
    private FullHttpResponse httpResponse;
    private Object result;
}
