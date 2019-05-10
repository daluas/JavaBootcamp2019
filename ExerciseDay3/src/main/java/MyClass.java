import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.IntUnaryOperator;
public class MyClass {
    //Rezolvare Exericitiu 1 din Java8Exercises
    public static String verifyOddEven(int number) {
        if (number % 2 == 0) {
            return "e" + number;
        } else {
            return "o" + number;
        }
    }

    public static Optional<String> evenOrOdd(List<Integer> list)
    {
        if(list == null || list.contains(null))
        {
            return Optional.empty();
        }
        return Optional.of(list.stream().map(MyClass::verifyOddEven).collect(Collectors.joining(", ")));
    }

    //Rezolvare Exercitiu 2 din Java8Exercises
    public static final int N = 5;
    public static int findNextLetter(int letter)
    {
        boolean isUpper = false;
        if(letter == 32)
        {
            return (char)(letter += N);
        }
        else
        {
            if(letter <= 90)
            {
                letter += 32;
                isUpper = true;
            }
            if(letter+N > 122)
            {
               return (isUpper)? (letter = N - 58 + letter) : (letter = N - 26 + letter) ;
            }
             return (isUpper)?(letter = letter - (32 - N)):(letter += N);

        }
    }
    public static int findPreviousLetter(int letter)
    {
        boolean isUpper = false;
        if(letter == (32 + N))
        {
            return (letter -= N);
        }
        else
        {
            if(letter < 97)
            {
                letter += 32;
                isUpper = true;
            }
            if(letter-N < 97)
            {
                return (isUpper)? (letter = 123 - N + (letter-97) - 32) : (letter = 123 - N + (letter-97)) ;
            }
            return (isUpper)?(letter = letter - (32 + N)):(letter -= N);

        }
    }
    public static Optional<String> codeOrDecodeCesar(String codeString,IntUnaryOperator modify)
    {
        if(codeString == null || codeString.equals("") || !codeString.matches("[A-Za-z% ]*"))
        {
            return Optional.empty();
        }
        char[] arrayOfCode = codeString.toCharArray();
        for(int i = 0 ;i<arrayOfCode.length;i++)
        {
            arrayOfCode[i] = (char)modify.applyAsInt(arrayOfCode[i]);
        }
        return Optional.of(new String(arrayOfCode));
    }
    public static void main(String[] args) {
        //TODO Java8Exercises Exercise 1
        System.out.println("====Exercise1====");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(evenOrOdd(list).orElse("Null list or null element in list"));
        System.out.println(evenOrOdd(new ArrayList<Integer>()).orElse("Null list or null element in list"));
        System.out.println(evenOrOdd(null).orElse("Null list or empty list"));

        //TODO Java8Exercises Exercise 2
        System.out.println("====Exercise2====");
        System.out.println("Codarea datelor");
        String firstCode = codeOrDecodeCesar("Ana are mere zero Zero WORA",MyClass::findNextLetter).orElse("String null or empty or not respecting format");
        System.out.println(firstCode);
        System.out.println(codeOrDecodeCesar("",MyClass::findNextLetter).orElse("String null or empty or not respecting format"));
        System.out.println(codeOrDecodeCesar(null,MyClass::findNextLetter).orElse("String null or empty or not respecting format"));
        System.out.println(codeOrDecodeCesar("qwdqwdqwd4342423424",MyClass::findNextLetter).orElse("String null or empty or not respecting format"));
        System.out.println("Decodarea datelor");
        System.out.println(codeOrDecodeCesar(firstCode,MyClass::findPreviousLetter).orElse("String null or empty or not respecting format"));


        //TODO Java8Exercises Exercise 3
        System.out.println("====Exercise3====");
        List<String> words = Arrays.asList("Hello","Hi","Somebody","Ana","has","apples","annhhHa","anaH");
        System.out.println("----Task1----");
        System.out.println(words.stream().reduce((a,b)->a.toUpperCase()+b.toUpperCase()).get());
        System.out.println("----Task2----");
        System.out.println(words.stream().map(String::toUpperCase).reduce(String::concat).get());
        System.out.println("----Task3----");
        System.out.println(words.stream().collect(Collectors.joining(", ")));
        System.out.println("----Task4----");
        System.out.println(words.stream().mapToInt(String::length).sum());
        System.out.println("----Task5----");
        words.stream().filter(elem->elem.matches(".*[hH].*")).forEach(System.out::println);





    }
}
