import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

public class MyClass {
    //Rezolvare Exericitiu 1 din Java8Exercises
    public static String verifyOddEven(int number) {

        if (number % 2 == 0) {

            return "e" + number;
        }
        return "o" + number;

    }

    public static String evenOrOdd(List<Integer> numberList) {

        return Optional.ofNullable(numberList)
                .map(MyClass::getFormatedParity)
                .orElse("The list is null");
    }

    public static String getFormatedParity(List<Integer> numberList){
        return numberList.stream()
                .filter(Objects::nonNull)
                .map(MyClass::verifyOddEven)
                .collect(Collectors.joining(", "));

    }

    //Rezolvare Exercitiu 2 din Java8Exercises
    public static final int N = 5;

    public static int findNextLetter(int letter) {
        boolean isUpper = false;
        if (letter == 32) {
            return (letter += N);
        }
        if (letter <= 90) {
            letter += 32;
            isUpper = true;
        }
        if (letter + N > 122) {
            return (isUpper) ? (letter = N - 58 + letter) : (letter = N - 26 + letter);
        }
        return (isUpper) ? (letter = letter - (32 - N)) : (letter += N);


    }

    public static int findPreviousLetter(int letter) {
        boolean isUpper = false;
        if (letter == (32 + N)) {
            return (letter -= N);
        }
        if (letter < 97) {
            letter += 32;
            isUpper = true;
        }
        if (letter - N < 97) {
            return (isUpper) ? (letter = 123 - N + (letter - 97) - 32) : (letter = 123 - N + (letter - 97));
        }
        return (isUpper) ? (letter = letter - (32 + N)) : (letter -= N);


    }

    public static String codeOrDecodeCesar(String codeString, IntUnaryOperator modify) {
        if (codeString == null || codeString.equals("") || !codeString.matches("[A-Za-z% ]*")) {
            return "Nu sunt respectate cerintele asupra stringului de input";
        }
        char[] arrayOfCode = codeString.toCharArray();
        for (int charIndex = 0; charIndex < arrayOfCode.length; charIndex++) {
            arrayOfCode[charIndex] = (char) modify.applyAsInt(arrayOfCode[charIndex]);
        }
        return new String(arrayOfCode);
    }

    public static void main(String[] args) {
        //TODO Java8Exercises Exercise 1
        System.out.println("====Exercise1====");

        List<Integer> list = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(MyClass.evenOrOdd(list));
        System.out.println(MyClass.evenOrOdd(null));
        System.out.println(MyClass.evenOrOdd(new ArrayList<>()));
        List<Integer> listNull = new ArrayList<>();
        listNull.add(null);
        listNull.add(2);
        System.out.println(MyClass.evenOrOdd(listNull));

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
        System.out.println(words.stream().filter(elem -> elem.matches(".*[hH].*")).count());

        //TODO Java8Exercises Exercise 4 (seful de clasa)
        List<Student> students = new ArrayList<>();

        Student student1 = new Student(13, "Ionel", "Popescu");
        Student student2 = new Student(14, "Mihai", "Ionescu");
        Student student3 = new Student(12, "Ghita", "Muresan");
        Student student4 = new Student(15, "Dorel", "Constructor");

        Student student5 = new Student(20, "Sorinel", "Common");
        Student student6 = new Student(22, "Gal", "Final");
        Student student7 = new Student(23, "Mircea", "Transient");
        Student student8 = new Student(24, "Diana", "Clasa");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);

        students.stream()
                .filter(student->student.getAge()<20)
                .forEach(stud->stud.setPresident(student1));
        students.stream()
                .filter(student->student.getAge()>=20)
                .forEach(stud->stud.setPresident(student5));
        Map<Student,List<Student>> mapOfStud = students.stream()
                .collect(Collectors.groupingBy(Student::getPresident));

        System.out.println(mapOfStud);

        //Declarativ
        System.out.println("======Declarativ======");
        Map<Student,List<Student>> mapOfStud2 = new HashMap<>();
        mapOfStud2.put(student1,new ArrayList<>());
        mapOfStud2.put(student5,new ArrayList<>());

        for(Student s : students) {

            if(s.getPresident().equals(student1)) {

                mapOfStud2.get(student1)
                        .add(s);
            }
            else {

                mapOfStud2.get(student5)
                        .add(s);
            }
        }
        System.out.println(mapOfStud2);


    }
}