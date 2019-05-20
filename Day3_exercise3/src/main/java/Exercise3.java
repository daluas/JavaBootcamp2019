import java.util.Arrays;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args){
        List<String> words = Arrays.asList("hi", "hello","hey","bye");
        words.stream().forEach(w-> System.out.println(w+" "));
        System.out.println(uppercase1(words));
        System.out.println(uppercase2(words));
        System.out.println("Concatenated strings: "+concatenated_string(words));
        System.out.println("Length of strings: "+length_of_strings(words));
        System.out.println("Number of words containin h: "+number_of_words_containing_h(words));
    }
    public static String uppercase1(List<String> list){
        String result=list.stream().reduce("", (string1, string2) -> string1+string2.toUpperCase());
        return result;

    }
    public static String uppercase2(List<String> list){
        String result=(list.stream().map(String::toUpperCase).reduce("",String::concat));
        return result;
    }
    public static String concatenated_string(List<String> list){
        String result=(list.stream().reduce("",(string1, string2) -> string1 + "," + string2));
        return result;
    }
    public static String length_of_strings(List<String>list){
        String result=(""+list.stream().mapToInt(String::length).sum());
        return result;
    }
    public static String number_of_words_containing_h(List<String> list){
        String result=(""+list.stream().filter(word->word.contains("h")).count());
        return result;
    }
}
