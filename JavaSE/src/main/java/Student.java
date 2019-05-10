
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{

    private int age;

    private String firstName;

    private String lastName;

    public List<Grade> grades = new ArrayList<>();

    public void setGrades(int score, String subjectName) {
        Grade grade = new Grade(score, subjectName);

        this.grades.add(grade);
    }

    public List<Grade> getGrades() {

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

    @Override
    public int compareTo(Student student) {

        int ageToCompare = student.getAge();
        return this.getAge() - ageToCompare;
    }
}