import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        //TODO NumberWithSquareSumOfSquareDivisorsFinder
        /// Given the limits of an interval, find all numbers in that interval for which the sum of the square of it's divisors is a perfect square
        /// The interval is closed on both ends (the limits should also be checked)
        /// Example:
        /// The divisors of 42 are [1, 2, 3, 6, 7, 14, 21, 42]
        /// The divisors squared are [1, 4, 9, 36, 49, 196, 441, 1764]
        /// The sum of the squared divisors is 2500 which is the perfect square of 50
        /// This means 42 respects the rule

        List<Student> students = new ArrayList<>();

        Student student1 = new Student(22, "Ionel", "Popescu",Arrays.asList(new Grades(4,"matematica"), new Grades(10,"biologie"), new Grades(7,"romana")));
        Student student2 = new Student(18, "Mihai", "Ionescu",Arrays.asList(new Grades(3,"matematica"), new Grades(8,"biologie"), new Grades(7,"romana")));
        Student student3 = new Student(21, "Ghita", "Muresan",Arrays.asList(new Grades(6,"matematica"), new Grades(9,"biologie"), new Grades(10,"romana")));
        Student student4 = new Student(17, "Dorel", "Constructor",Arrays.asList(new Grades(6,"matematica"), new Grades(7,"biologie"), new Grades(8,"romana")));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //TODO Sort the students by age
        List<Student> sorted_list = students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        System.out.println("Students sorted by age: ");
        sorted_list.stream().forEach(s -> System.out.println(s.toString()));
        //TODO Display only the students that are above 20 years
        System.out.print("Students above 20: \n");
        /*for(int i=0;i<students.size();i++) {
            if (students.get(i).getAge() > 20) {
                String stud=students.get(i).toString();
                System.out.println( stud);

            }
        }*/

        students.stream().filter(s -> s.getAge() > 20).forEach(s -> System.out.println(s.toString()));
        //TODO Display only the students that have their lastname ending in escu
        System.out.println("students that have their lastname ending in escu");
        students.stream().filter(s -> s.getLastName().endsWith("escu")).forEach(s -> System.out.println(s.toString()));
        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.
        System.out.println("lastNames of the students that have no grade lower than 5 are:");
        Student.DisplayGradesLower(students);



    }
}
