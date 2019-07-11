package misc;

import java.lang.annotation.*;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Annotations1 {

    //@Target 
    //注解用于什么地方
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @interface MyAnnotation {
    }

    //@Repeatable
    //被注解的注解，可以在一个属性上重复使用
    @Repeatable(Hints.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hint {
        String value();
    }

    //@Retention
    //什么时候使用该注解
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hints {
        Hint[] value();
    }

    @Hint("hint1")
    @Hint("hint2")
    class Person {

    }

    public static void main(String[] args) {
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);

        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);
    }
}
