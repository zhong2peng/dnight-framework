package com.dnight.base.framework.common.configuration;

import com.dnight.base.framework.common.vo.ExceptionVO;
import com.dnight.base.framework.common.vo.FieldExceptionVO;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SwaggerConfiguration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements ApplicationListener<WebServerInitializedEvent> {

    @Autowired
    private TypeResolver typeResolver;

    /**
     * 对外服务swagger文档分组
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {

        ModelRef errorModel = new ModelRef("ExceptionVO");

        List<ResponseMessage> responseMessages = Arrays.asList(
                new ResponseMessageBuilder().code(409).message("Conflict")
                        .responseModel(new ModelRef("FieldExceptionVO")).build(),
                new ResponseMessageBuilder().code(403).message("Forbiddon").responseModel(null).build(),
                new ResponseMessageBuilder().code(404).message("Not Found").responseModel(errorModel).build(),
                new ResponseMessageBuilder().code(500).message("Intenal Error").responseModel(null).build());

        List<Parameter> headerParameter = new ArrayList<Parameter>();

        Predicate<RequestHandler> package1 = RequestHandlerSelectors.basePackage("com.dnight.base.framework");
        return new Docket(DocumentationType.SWAGGER_2).select().apis(Predicates.or(package1))
                .paths(PathSelectors.any()).build()// .groupName("外部接口")
                .globalOperationParameters(headerParameter).apiInfo(apiInfo()).useDefaultResponseMessages(false)
                .additionalModels(typeResolver.resolve(FieldExceptionVO.class), typeResolver.resolve(ExceptionVO.class))
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages);

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("组织", "", "standard@com.cn");
        return new ApiInfoBuilder().title("Base Standard web API  DOC").contact(contact).description("基本框架搭建").build();
    }

    private String getAddress() {
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            hostAddress = "127.0.0.1";
        }
        return hostAddress;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int serverPort = event.getWebServer().getPort();
        System.err.println("swagger访问地址:http://" + getAddress() + ":" + serverPort + "/swagger-ui.html");
    }
}
