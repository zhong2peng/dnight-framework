package com.geccocrawler.gecco.dynamic;

import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;

public interface DynamicField {

    /**
     * 动态生成属性注解
     *
     * @return DynamicField
     */
    DynamicField request();

    DynamicField requestParameter(String param);

    DynamicField requestParameter();

    /**
     * replace by csspath
     *
     * @param cssPath cssPath
     * @return DynamicField
     */
    @Deprecated
    DynamicField htmlField(String cssPath);

    DynamicField csspath(String cssPath);

    DynamicField text(boolean own);

    DynamicField text();

    DynamicField html(boolean outer);

    DynamicField href(boolean click, String... value);

    DynamicField href(String... value);

    DynamicField image(String download, String... value);

    DynamicField image();

    DynamicField attr(String value);

    DynamicField ajax(String url);

    DynamicField jsvar(String var, String jsonpath);

    DynamicField jsvar(String var);

    DynamicField jsonpath(String value);

    DynamicField renderName(String value);

    DynamicBean build();

    DynamicField customAnnotation(Annotation annotation);

    ConstPool getConstPool();
}
