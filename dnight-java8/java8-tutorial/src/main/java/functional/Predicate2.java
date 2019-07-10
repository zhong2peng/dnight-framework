package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Predicate2 {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J : ");
        filter(languages, str -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, str -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, str -> true);

        System.out.println("Print no languages :");
        filter(languages, str -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, str -> str.length() > 4);

        System.out.println("multi condition organize");
        Predicate<String> startWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() == 4;
        languages.stream().filter(startWithJ.and(fourLetterLong)).forEach(System.out::println);
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}
