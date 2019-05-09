import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("something"));

        List<String> someList = Arrays.asList("unu", "doi", "trei");
        Set<String> set = someList.stream().flatMap(Collectors.toSet());
        someList.forEach(System.out::println);

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println(Util.getNameWithouthLambda(a));
        System.out.println(Util.getNameWithLambda(a));



    }
}
