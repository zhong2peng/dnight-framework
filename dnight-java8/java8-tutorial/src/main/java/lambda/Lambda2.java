package lambda;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Lambda2 {

    public interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {

        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);

        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);

        Something something = new Something();

        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java Lambda");
        System.out.println(converted3);

        PersonFactory<Person> personFactory = Person::new;
        Person p1 = personFactory.create("Peter", "Parker");
        System.out.println(p1.firstName + " " + p1.lastName);
    }
}
