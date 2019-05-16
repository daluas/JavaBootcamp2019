import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExersiseTwo {

    public static Map<String, BiFunction<String, Double, Grades>> Gradesfactory = new HashMap<>();

    static {
        Gradesfactory.put("Grades", Grades::new);
    }

    public static Random rand = new Random(47);

    //TODO NumberWithSquareSumOfSquareDivisorsFinder

    private static List<Integer> getDivisors(int testedNumber) {

        final int constantTestedNumber;

        if (testedNumber < 0) {
           testedNumber = -testedNumber;
        }

        constantTestedNumber = testedNumber;

        return IntStream.rangeClosed(1,testedNumber)
                 .filter(number->constantTestedNumber % number == 0)
                 .boxed()
                 .collect(Collectors.toList());
    }

    public static List<Integer> numberWithSquare(int firstBound, int secondBound) {

        if (firstBound > secondBound) {
            System.out.println("Bounds error");
            return null;
        }

       return IntStream.rangeClosed(firstBound,secondBound)
               .filter(ExersiseTwo::verifyAllConditions)
               .boxed()
               .collect(Collectors.toList());


    }
    private static boolean verifySquareCondition(int sumbOfPowDivisors){

        return Math.sqrt(sumbOfPowDivisors) == (int) Math.sqrt(sumbOfPowDivisors);
    }
    private static int getSumOfPowDivisors(int testedNumber){
        return getDivisors(testedNumber).stream()
                .map(element->element*element)
                .reduce(0,Integer::sum);
    }
    private static boolean verifyAllConditions(int testedNumber){

        return Optional.of(testedNumber)
                .map(ExersiseTwo::getSumOfPowDivisors)
                .filter(ExersiseTwo::verifySquareCondition)
                .isPresent();
    }

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

        Student student1 = new Student(22, "Ionel", "Popescu");
        Student student2 = new Student(18, "Mihai", "Ionescu");
        Student student3 = new Student(21, "Ghita", "Muresan");
        Student student4 = new Student(17, "Dorel", "Constructor");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //TODO Sort the students by age
        //TODO Display only the students that are above 20 years
        //TODO Display only the students that have their lastname ending in escu
        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.

        System.out.println("======TODO0 NumberWithSquareSumOfSquareDivisorsFinder =====");

        System.out.println("In acest interval se gasesc numerele : " + numberWithSquare(-100, -7) + " care respecta conditia");
        System.out.println("In acest interval se gasesc numerele : " + numberWithSquare(1,1) + "  care respecta conditia");
        System.out.println("In acest interval se gasesc numerele : " + numberWithSquare(2,3) + "  care respecta conditia");

        System.out.println("======TODO1=====");
        students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
        System.out.println("======TODO2=====");
        students.stream()
                .filter(student -> student.getAge() > 20)
                .forEach(System.out::println);
        System.out.println("======TODO3=====");
        students.stream()
                .filter(student -> student.getLastName().matches("[A-Za-z]*escu"))
                .forEach(System.out::println);
        System.out.println("======TODO4=====");


        students.forEach(stud -> stud.insertGrade(Gradesfactory.get("Grades").apply("Matematica", (double) rand.nextInt(10))));
        students.forEach(stud -> stud.insertGrade(Gradesfactory.get("Grades").apply("Matematica", (double) rand.nextInt(10))));
        System.out.println(students);


        System.out.println("======TODO5=====");


        students.stream()
                .filter(stud -> stud.getGradesList()
                        .stream()
                        .allMatch(grade -> grade.getScore() >= 5))
                .map(Student::getLastName)
                .forEach(System.out::println);


    }
}