import java.util.*;
import java.util.stream.Collectors;

public class Main {

    //1-)Write a method that returns a comma separated string based on a given list of integers.
    // Each element should be preceded by the letter 'e' if the number is even,
    // and preceded by the letter 'o' if the number is odd. For example,
    // if the input list is (3,44), the output should be 'o3,e44'.

    private static String ex1(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream().map(e -> e % 2 == 0 ? "e" + e + "," : "o" + e + ",")
                .forEach(stringBuilder::append);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    //2-)The Ceasar cipher is a basic encryption technique used by Julius Ceasar to securely
    // communicate with his generals. Each letter is replaced by another letter N positions
    // down the english alphabet. For example, for a rotation of 5, the letter 'c' would be
    // replaced by an 'h'. In case of a 'z', the alphabet rotates and it is transformed into a 'd'.
    //Implement a decoder for the Ceasar cipher where N = 5.
    //TIP: Use code.toCharArray() to get an array of characters.

    private static char rotateLetter(char letter, int step) {
       return (char) ((letter % 97 + step) % 26 + 97);
    }

    private static String ceasarCipher(String code, int n) {
        StringBuilder result = new StringBuilder();
        for(char chr : code.toCharArray()) {
            result.append(rotateLetter(chr, n));
        }
        return result.toString();
    }

    //3-)For these exercises, start with a List of Strings similar to this:
    //• List<String> words = Arrays.asList("hi", "hello", ...);
    //1. Produce a single String that is the result of concatenating the uppercase versions of all of the
    //Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
    //2. Produce the same String as above, but this time via a map operation that turns the words into upper
    //case, followed by a reduce operation that concatenates them.
    //3. Produce a String that is all the words concatenated together, but with commas in between. E.g., the
    //result should be "hi,hello,...". Note that there is no comma at the beginning, before “hi”, and also no
    //comma at the end, after the last word. Major hint: there are two versions of reduce discussed in the
    //notes.
    //4. Find the total number of characters (i.e., sum of the lengths) of the strings in the List.
    //5. Find the number of words that contain an “h”

    private static void ex3(List<String> words) {
        String result;
        result = words.stream().reduce("", (e1, e2) -> e1.toUpperCase() + e2.toUpperCase());
        System.out.println("1. Single reduce operation: " + result);
        result = words.stream().map(String::toUpperCase).reduce("", (e1, e2) -> e1 + e2);
        System.out.println("2. Map and reduce: " + result);
        result = words.stream().collect(Collectors.joining(",")); // .reduce("", (e1, e2) -> e1 + "," + e2);
        System.out.println("3. Comma separated: " + result);
        int resultNumber;
        resultNumber = words.stream().map(String::length).reduce(0, (e1, e2) -> e1 + e2);
        System.out.println("4. Sum of the number of characters: " + resultNumber);
        resultNumber = words.stream().map(e -> e.contains("h") ? 1 : 0).reduce(0, (e1, e2) -> e1 + e2);
        System.out.println("5. Number of words that contain 'h': " + resultNumber);
    }

    //Every class in highschool has a designated president. Because of that, we'll store all the classes as a Map<Student,List<Student>>
    //where the key is the president student and value List<Student> represents all the students in his class.
    //Using this structure, aggregate all the students into a single list using both approaches,
    //declarative and with streams and print all the students name on the console.

    private static Map<Student, List<Student>> generateDefaultPresidentMap() {
        Map<Student, List<Student>> presidentStudents = new HashMap<>();
        Student student1 = new Student(22, "Ionel", "Popescu");
        Student student2 = new Student(18, "Mihai", "Ionescu");
        Student student3 = new Student(21, "Ghita", "Muresan");
        Student student4 = new Student(17, "Dorel", "Constructor");
        Student student5 = new Student(15, "Marius", "Parasca");
        Student student6 = new Student(23, "Ciprian", "Cozma");
        List<Student> students = Arrays.asList(student1, student2, student3);
        presidentStudents.put(student1, students);
        students = Arrays.asList(student4, student5, student6);
        presidentStudents.put(student4, students);
        return presidentStudents;
    }

    private static void ex4(Map<Student, List<Student>> presidentStudents) {
        List<Student> declarativeApproach = new ArrayList<>();
        List streamsApproach;
        for(Map.Entry<Student, List<Student>> entry : presidentStudents.entrySet()) {
            declarativeApproach.addAll(entry.getValue());
        }

        System.out.println("Declarative approach: " + declarativeApproach);

        streamsApproach = presidentStudents.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("Stream approach: " + streamsApproach);

    }

    public static void main(String[] args) {
        System.out.println("Ex1: " + ex1(new ArrayList<>(Arrays.asList(3, 44))));
        System.out.println("Ex2: " + ceasarCipher("abczw", 5));
        System.out.println("Ex3: ");
        ex3(Arrays.asList("hi", "hello", "marius"));
        ex4(generateDefaultPresidentMap());
    }
}
