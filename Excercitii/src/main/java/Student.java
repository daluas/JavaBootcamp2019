import java.util.List;
import java.util.ArrayList;
public class Student {

    private int age;

    private String firstName;

    private String lastName;

    private List<Grades> gradesList;

    public Student(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        gradesList = new ArrayList<>();
    }

    public void insertGrade(Grades grades)
    {
        gradesList.add(grades);
    }

    public List<Grades> getGradesList()
    {
        return gradesList;
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

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + " gradeList= "+
                gradesList + " }'";
    }
}