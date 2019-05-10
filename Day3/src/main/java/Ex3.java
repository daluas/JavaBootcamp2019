import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
3-)For these exercises, start with a List of Strings similar to this:
• List<String> words = Arrays.asList("hi", "hello", ...);
1. Produce a single String that is the result of concatenating the uppercase versions of all of the
Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
2. Produce the same String as above, but this time via a map operation that turns the words into upper
case, followed by a reduce operation that concatenates them.
3. Produce a String that is all the words concatenated together, but with commas in between. E.g., the
result should be "hi,hello,...". Note that there is no comma at the beginning, before “hi”, and also no
comma at the end, after the last word. Major hint: there are two versions of reduce discussed in the
notes.
4. Find the total number of characters (i.e., sum of the lengths) of the strings in the List.
5. Find the number of words that contain an “h”
 */


public class Ex3 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi","hello","salve","bonjour","hola");
        String result1 = words.stream().reduce("",(x,y) -> x.toUpperCase()+y.toUpperCase());
        System.out.println("Ex 3 subpct 1: " + result1);

        String result2 = words.stream().map(String::toUpperCase).reduce("",(x, y)->x+y);
        System.out.println("Ex 3 subpct 2: " + result2);

        Optional<String> result3 = words.stream().reduce((s1, s2) -> s1 + "," + s2);
        System.out.println("Ex 3 subpct 3: " + result3.get());

        int sum = words.stream().mapToInt(String::length).sum();
        System.out.println("Ex 3 subpct 4: " + sum);

        long occurence = words.stream().filter(x -> x.contains("h")).count();
        System.out.println("Ex 3 subpct 5: " + occurence);
    }

}
