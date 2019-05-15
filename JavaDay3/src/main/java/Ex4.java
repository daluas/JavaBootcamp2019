import org.omg.CORBA.StringHolder;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Ex4 {


    public static void main(String[] args) {

        List<Student> declarativeList = new ArrayList<>();
        List<Student> streamList = new ArrayList<>();
        Map<Student, List<Student>> classWithPresident = new HashMap();
        Student student1 = new Student(18, "Fred", "Flintstone");
        Student student2 = new Student(22, "Jack", "Samurai");
        Student student3 = new Student(21, "Alex", "Mercer");
        Student student4 = new Student(23, "God", "Of War");
        Student student5 = new Student(29, "Ezio", "Auditore");
        Student student6 = new Student(18, "Thomas", "Shelby");
        Student student7 = new Student(57, "Ceva", "Nume");

        List<Student> students = Arrays.asList(student1, student2, student3);
        classWithPresident.put(student6, students);

        students = Arrays.asList(student4, student5);
        classWithPresident.put(student7, students);

        System.out.println("Declarative: ");
        for(Map.Entry<Student, List<Student>> student : classWithPresident.entrySet()){
            declarativeList.addAll(student.getValue());
        }
        for(Student stud : declarativeList){
            System.out.println(stud.toString());
        }

        System.out.println("Stream: ");
        streamList = classWithPresident.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        for(Student stud : streamList){
            System.out.println(stud.toString());
        }


    }



}
