import java.util.*;
import java.util.stream.Collectors;

public class Student {

    private int age;

    private String firstName;

    private String lastName;

    private List<Grades> grades;

    public Student(int age, String firstName, String lastName, List<Grades> grades) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades=grades;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void DisplayGradesLower(List<Student> students){
        for(Student student : students){
            if(student.getGrades().stream().filter(g -> g.getScore() <5).collect(Collectors.toList()).isEmpty()){
                System.out.println(student.getLastName());
            }
        }
    }
}

