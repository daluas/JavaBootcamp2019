import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

//TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
public class Student implements Serializable {

    private int age;

    transient private String firstName;

    private String lastName;

    private List<Grades> grades;

    public Student(int age, String firstName, String lastName, List<Grades> grades) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
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
                ", grades=" + grades.toString() +
                '}';
    }

    public static void DisplayGradesLower(List<Student> students){
        for(Student student : students){
            if(student.getGrades().stream().filter(g -> g.getScore() <5).collect(Collectors.toList()).isEmpty()){
                System.out.println(student.toString());
            }
        }
        //SAU
        // students.stream().filter(s -> s.getGrades().stream().allMatch(g -> g.getScore() >5)).map(Student::getLastName).forEach(System.out::println);

    }
}
