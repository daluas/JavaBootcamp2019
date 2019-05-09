import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercises {

    public static List<Integer> GetDivisors(int number) {
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {

                if (number / i == i) {
                    divisorList.add(i);
                } else {
                    divisorList.add(i);
                    divisorList.add(number / i);
                }
            }
        }
        return divisorList;
    }

    public static Boolean isPerfectSquare(int number){
        List<Integer> divisorList = GetDivisors(number);
        Double squaredSum = divisorList.stream().map(x ->Math.pow(x,2)).reduce(0.0, Double::sum);
        if((Math.sqrt(squaredSum) * Math.sqrt(squaredSum)) == squaredSum)
            return true;
        else
            return false;
    }

    public static List<Integer> NumberWithSquareSumOfSquareDivisorsFinder(int a, int b){
        List<Integer> perfectSquares = new ArrayList<>();
        List<Integer> returnList = new ArrayList<>();
        for(int i=a; i<=b;++i){
            perfectSquares.add(i);
        }
        for(Integer number : perfectSquares){
            if(isPerfectSquare(number))
            {
                returnList.add(number);
            }
        }
        return returnList;
    }


    public static void main(String[] args) {


        //TODO NumberWithSquareSumOfSquareDivisorsFinder;
        List<Integer> perfectSquares = NumberWithSquareSumOfSquareDivisorsFinder(40,44);
        System.out.println("List of perfect squares are: ");
        perfectSquares.stream().forEach(System.out::println);
        /// Given the limits of an interval, find all numbers in that interval for which the sum of the square of it's divisors is a perfect square
        /// The interval is closed on both ends (the limits should also be checked)
        /// Example:
        /// The divisors of 42 are [1, 2, 3, 6, 7, 14, 21, 42]
        /// The divisors squared are [1, 4, 9, 36, 49, 196, 441, 1764]
        /// The sum of the squared divisors is 2500 which is the perfect square of 50
        /// This means 42 respects the rule

        List<Student> students = new ArrayList<>();

        Student student1 = new Student(22, "Ionel", "Popescu",Arrays.asList(new Grades(5,"matematica"), new Grades(6,"romana"), new Grades(7,"matematica")));
        Student student2 = new Student(18, "Mihai", "Ionescu",Arrays.asList(new Grades(5,"matematica"), new Grades(4,"romana"), new Grades(3,"romana")));
        Student student3 = new Student(21, "Ghita", "Muresan",Arrays.asList(new Grades(10,"matematica"), new Grades(9,"romana"),new Grades(10,"geografie")));
        Student student4 = new Student(17, "Dorel", "Escusan",Arrays.asList(new Grades(6,"matematica"), new Grades(7,"romana"),new Grades(6,"matematica")));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //TODO Sort the students by age
        students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        List<Student> sortedStudents = students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        System.out.println("Students sorted by age: ");
        sortedStudents.stream().forEach(s -> System.out.println(s.getAge()));
        //TODO Display only the students that are above 20 years
        System.out.println("All students over 20: ");
        students.stream().filter(s -> s.getAge() > 20).forEach(s -> System.out.println(s.getAge()));
        //TODO Display only the students that have their lastname ending in escu
        System.out.println("All students whose last name ends in escu ");
        students.stream().filter(s -> s.getLastName().endsWith("escu")).forEach(s -> System.out.println(s.getLastName()));
        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.
        System.out.println("Display all students that have no grades lower than 5");

        Student.DisplayGradesLower(students);

    }
}

