import java.util.*;
import java.util.stream.Collectors;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

public class MyClass {
    //Rezolvare Exericitiu 1 din Java8Exercises
    public static String verifyOddEven(int number) {
        if (number % 2 == 0) {
            return "e" + number;
        } else {
            return "o" + number;
        }
    }

    public static Optional<String> evenOrOdd(List<Integer> list) {

        return Optional.ofNullable(list)
                .map(l -> l.stream()
                        .filter(Objects::nonNull).map(MyClass::verifyOddEven).collect(Collectors.joining(", ")));
    }

    //Rezolvare Exercitiu 2 din Java8Exercises
    public static final int N = 5;

    public static int findNextLetter(int letter) {
        boolean isUpper = false;
        if (letter == 32) {
            return (letter += N);
        } else {
            if (letter <= 90) {
                letter += 32;
                isUpper = true;
            }
            if (letter + N > 122) {
                return (isUpper) ? (letter = N - 58 + letter) : (letter = N - 26 + letter);
            }
            return (isUpper) ? (letter = letter - (32 - N)) : (letter += N);

        }
    }

    public static int findPreviousLetter(int letter) {
        boolean isUpper = false;
        if (letter == (32 + N)) {
            return (letter -= N);
        } else {
            if (letter < 97) {
                letter += 32;
                isUpper = true;
            }
            if (letter - N < 97) {
                return (isUpper) ? (letter = 123 - N + (letter - 97) - 32) : (letter = 123 - N + (letter - 97));
            }
            return (isUpper) ? (letter = letter - (32 + N)) : (letter -= N);

        }
    }

    public static String codeOrDecodeCesar(String codeString, IntUnaryOperator modify) {
        if (codeString == null || codeString.equals("") || !codeString.matches("[A-Za-z% ]*")) {
            return "Nu sunt respectate cerintele asupra stringului de input";
        }
        char[] arrayOfCode = codeString.toCharArray();
        for (int i = 0; i < arrayOfCode.length; i++) {
            arrayOfCode[i] = (char) modify.applyAsInt(arrayOfCode[i]);
        }
        return new String(arrayOfCode);
    }

    public static void main(String[] args) {
        //TODO Java8Exercises Exercise 1
        System.out.println("====Exercise1====");

        List<Integer> list = Stream.iterate(0, n -> n + 1).limit(10).collect(Collectors.toList());
        System.out.println(MyClass.evenOrOdd(list).orElse("Lista este null "));
        System.out.println(MyClass.evenOrOdd(null).orElse("Lista este null "));
        System.out.println(MyClass.evenOrOdd(new ArrayList<>()));
        List<Integer> listNull = new ArrayList<>();
        listNull.add(null);
        listNull.add(2);
        System.out.println(MyClass.evenOrOdd(listNull).orElse("Lista este null"));

        //TODO Java8Exercises Exercise 2
        System.out.println("====Exercise2====");
        System.out.println("Codarea datelor");
        String firstCode = codeOrDecodeCesar("Ana are mere zero Zero WORA", MyClass::findNextLetter);
        System.out.println(firstCode);
        System.out.println(codeOrDecodeCesar("", MyClass::findNextLetter));
        System.out.println(codeOrDecodeCesar(null, MyClass::findNextLetter));
        System.out.println(codeOrDecodeCesar("qwdqwdqwd4342423424", MyClass::findNextLetter));
        System.out.println("Decodarea datelor");
        System.out.println(codeOrDecodeCesar(firstCode, MyClass::findPreviousLetter));


        //TODO Java8Exercises Exercise 3
        System.out.println("====Exercise3====");
        List<String> words = Arrays.asList("Hello", "Hi", "Somebody", "Ana", "has", "apples", "annhhHa", "anaH");
        System.out.println("----Task1----");
        System.out.println(words.stream().reduce((a, b) -> a.toUpperCase() + b.toUpperCase()).get());
        System.out.println("----Task2----");
        System.out.println(words.stream().map(String::toUpperCase).reduce(String::concat).get());
        System.out.println("----Task3----");
        System.out.println(words.stream().collect(Collectors.joining(", ")));
        System.out.println("----Task4----");
        System.out.println(words.stream().mapToInt(String::length).sum());
        System.out.println("----Task5----");
        words.stream().filter(elem -> elem.matches(".*[hH].*")).forEach(System.out::println);


    }
}