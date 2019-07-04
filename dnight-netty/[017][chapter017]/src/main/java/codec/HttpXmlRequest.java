package codec;

import io.netty.handler.codec.http.FullHttpRequest;
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
public class HttpXmlRequest {

    private FullHttpRequest request;
    private Object body;
}
