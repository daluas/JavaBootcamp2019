/*
Every class in highschool has a designated president. Because of that, we'll store all the classes as a Map<Student,List<Student>>
where the key is the president student and value List<Student> represents all the students in his class.
Using this structure, aggregate all the students into a single list using both approaches,
declarative and with streams and print all the students name on the console.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4 {

    public static void main(String[] args) {
        Map<Student, List<Student>> classes = new HashMap<>();
        List<Student> allStudentsV1 = new ArrayList<>();
        classes.put(new Student(20, "Marian", "Popescu"), Arrays.asList(new Student(19, "Ioan", "Bumbaru"), new Student(18, "Gabriela", "Constantinescu")));
        classes.put(new Student(17, "Vali", "Georgescu"), Arrays.asList(new Student(21, "Elena", "Nasturas"), new Student(19, "Cristina", "Archip")));

        System.out.println("Declarative method: ");
        for(Map.Entry students :classes.entrySet()){
            List<Student> auxList = (List<Student>) students.getValue();
            allStudentsV1.addAll(auxList);
        }
        for (Student student : allStudentsV1) {
            System.out.println(student.toString());
        }

        System.out.println("Functional method: ");
        //Optional<List<Student>> allStudentsV2 = classes.entrySet().stream().map(Map.Entry::getValue).reduce((x, y) -> Stream.of(x, y).flatMap(Collection::stream).collect(Collectors.toList()));
        List<Student> allStudentsV3 = classes.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        for (Student student : allStudentsV3) {
            System.out.println(student.toString());
        }
    }
}
