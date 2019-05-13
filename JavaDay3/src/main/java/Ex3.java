import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex3 {

    public static void main(String[] args) {

        List<String> wordsList = Arrays.asList("hi", "hello", "yo", "abc");
        String result1, result2;
        int sum;

        //Ex3Sbp1
        result1 = wordsList.stream().reduce("",(x,y)-> x.toUpperCase() + y.toUpperCase());
        System.out.println("Ex3Sbp1: " + result1);

        //Ex3Sbp2

        result2 = wordsList.stream().map(String::toUpperCase).reduce("",(x,y) -> x + y);
        System.out.println("Ex3Sbp2: " + result2);

        //Ex3Sbp3
        Optional<String> result3 = wordsList.stream().reduce((x, y) -> x + "," + y);
        System.out.println("Ex3Sbp3: " + result3);

        //Ex3Sbp4
        sum = wordsList.stream().mapToInt(String::length).sum();
        System.out.println("Ex3Sbp4: " + sum);

        //Ex3Sbp5
        System.out.println("Ex3Sbp5: " + wordsList.stream().filter(s -> s.contains("h")).count());

    }
}
