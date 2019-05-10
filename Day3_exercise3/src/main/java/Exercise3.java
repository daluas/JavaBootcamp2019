import java.util.Arrays;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args){
        List<String> words = Arrays.asList("hi", "hello","hey","bye");
        words.stream().forEach(w-> System.out.println(w+" "));
        uppercase1(words);
        uppercase2(words);
        concatenated_string(words);
        length_of_strings(words);
        number_of_words_containing_h(words);
    }
    public static void uppercase1(List<String> list){
        System.out.println(list.stream().reduce("Result1: ", (string1, string2) -> string1+string2.toUpperCase()));
    }
    public static void uppercase2(List<String> list){
        System.out.println(list.stream().map(String::toUpperCase).reduce("Result2: ",String::concat));
    }
    public static void concatenated_string(List<String> list){
        System.out.println(list.stream().reduce("Result3:",(string1, string2) -> string1 + "," + string2));
    }
    public static void length_of_strings(List<String>list){
        System.out.println("Length of strings: "+list.stream().mapToInt(String::length).sum());
    }
    public static void number_of_words_containing_h(List<String> list){
        System.out.println("Number of words containing h is: "+list.stream().filter(word->word.contains("h")).count());
    }
}
