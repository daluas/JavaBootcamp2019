import java.util.*;
import java.util.stream.Collectors;

public class ExercitiiStefan {

    public static void displayGoodStudents(List<Student> students){

        Set<Student> goodStudents = new HashSet<>();

        for(Student stud:students){
            for(Grade grade:stud.getGrades()){
                if(grade.getScore() > 4){
                    goodStudents.add(stud);
                }
            }
        }
        for(Student stud:goodStudents){
            System.out.println(stud.getLastName());
        }
    }

    public static boolean checkSquareSum(long num){
        int it;
        long squaredSum = 0;
        for(it = 1; it <=  num; it++){
            if(num % it == 0){
                squaredSum += Math.pow(it,2);
            }
        }
        if (Math.sqrt(squaredSum) - Math.floor(Math.sqrt(squaredSum)) == 0){
            return true;
        }
        return false;
    }

    public static void findZaNumber(int startLimit, int finisLimit){
        int it;
        for(it = startLimit; it <= finisLimit; it++){
            if(checkSquareSum(it)){
                System.out.println(it);
            }
        }
    }

    public static void main(String[] args) {
        //TODO numberWithSquareSumOfSquareDivisorsFinder
        /// Given the limits of an interval, find all numbers in that interval for which the sum of the square of it's divisors is a perfect square
        /// The interval is closed on both ends (the limits should also be checked)
        /// Example:
        /// The divisors of 42 are [1, 2, 3, 6, 7, 14, 21, 42]
        /// The divisors squared are [1, 4, 9, 36, 49, 196, 441, 1764]
        /// The sum of the squared divisors is 2500 which is the perfect square of 50
        /// This means 42 respects the rule
        System.out.println("Ex with squared sums: " + "\n");
        findZaNumber(1,50);
        findZaNumber(1,1000);

        List<Student> students = new ArrayList<>();
        List<Student> sortedStudents;

        Student student1 = new Student(22, "Ionel", "Popescu");
        Student student2 = new Student(18, "Mihai", "Ionescu");
        Student student3 = new Student(21, "Ghita", "Muresan");
        Student student4 = new Student(17, "Dorel", "Constructor");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //TODO Sort the students by age

        System.out.println("Sorted students:" + "\n");
        Collections.sort(students);
        for(Student s:students){
            System.out.println(s);
        }

        System.out.println("Sorted students using streams:" + "\n");

        sortedStudents = students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        sortedStudents.forEach(s -> System.out.println(s));

        //TODO Display only the students that are above 20 years

        System.out.println("Students with age >= 20:" + "\n");
        for(Student s: students){
            if(s.getAge() > 19){
                System.out.println(s);
            }
        }

        System.out.println("Students with age >= 20 using streams:" + "\n");

        students.stream().filter(s -> s.getAge() > 19).forEach(s -> System.out.println(s));

        //TODO Display only the students that have their lastname ending in escu

        System.out.println("Students with the last name ended in escu:" + "\n");

        for(Student stud:students){
            if(stud.getLastName().endsWith("escu" + "\n")){
                System.out.println(stud);
            }
        }

        System.out.println("Students with the last name ended in escu using streams:" + "\n");

        students.stream().filter(stud -> stud.getLastName().endsWith("escu")).forEach(stud -> System.out.println(stud));

        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        student1.setGrades(10, "POO");
        student1.setGrades(8,"Alchimie");
        student2.setGrades(2,"Mate");
        student3.setGrades(6,"Fizica");
        student4.setGrades(3,"Chimie");
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.

        System.out.println("Student with grades >= 5:" + "\n");
        displayGoodStudents(students);

        System.out.println("Student with grades >= 5 using streams:" + "\n");

        students.stream().filter(stud -> stud.getGrades().stream().allMatch(grade -> grade.getScore() > 4)).forEach(s -> System.out.println(s.getLastName()));

    }
}
