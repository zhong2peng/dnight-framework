package codec;

import org.jboss.marshalling.*;

import java.io.IOException;

/**
 * @author ZHONGPENG769
 * @date 2019/7/5
 */
public class MarshallingCodecFactory {

    protected static Marshaller buildMarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        return marshallerFactory.createMarshaller(configuration);
    }

    protected static Unmarshaller buildUnMarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        return marshallerFactory.createUnmarshaller(configuration);
    }
}
