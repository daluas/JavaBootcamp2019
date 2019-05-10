import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise4 {
    public static void main(String[] args){
        Map<Student,List<Student>> students=new HashMap<>();
        Student president=new Student(22,"Ana","Voiculescu");
        Student student1=new Student(20,"Adina","Popescu");
        Student student2=new Student(21,"Mihaela","Popa");
        Student student3=new Student(22,"Cristina","Ionescu");
        List<Student>list=Arrays.asList(student1,student2,student3);
        students.put(president,list);
        declarative_method(students);
        streams_method(students);
    }
    public static void declarative_method(Map<Student,List<Student>> students){
        for (Map.Entry<Student, List<Student>> entry : students.entrySet()) {
            System.out.println("President: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
        }
    }
    public static void streams_method(Map<Student,List<Student>> students) {
        System.out.println(students.entrySet().stream().map(entry -> "President: "+entry.getKey() + "\nStudents: " + entry.getValue()).collect(Collectors.toList()));
    }

}
