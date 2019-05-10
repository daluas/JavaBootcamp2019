import java.util.List;

public class Student {

    private int age;

    private String firstName;

    private String lastName;

    private List<Grades> grades;

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }

    public List<Grades> getGrades() {

        return grades;
    }

    public Student(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
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
                ", lastName='" + lastName + '\'' +
                "Grades: " + grades +'}';
    }
}
