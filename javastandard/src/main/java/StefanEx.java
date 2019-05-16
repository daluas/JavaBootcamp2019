import java.util.*;
import java.util.stream.Collectors;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

public class StefanEx {

    public static long findNumberSumOfDivisorsSquared(int number) {
        long sum = 1;
        for(int i = 2; i < number; i++) {
            sum += getNumberSquaredIfEven(number, i);
        }
        sum += number*number;
        return sum;
    }

    private static long getNumberSquaredIfEven(int number, int i) {
        if(number % i == 0) {
            return i*i;
        }
        return 0;
    }

    public static boolean isPerfectSquare(long number) {
        double sqrt = Math.sqrt(number);
        return (sqrt - Math.floor(sqrt)) == 0;
    }

    public static List<Integer> numberWithSquareSumOfSquareDivisorsFinder(int begin, int end) {
        List<Integer> result = new ArrayList<>();
        for(int number = begin; number <= end; number++) {
            long aux = findNumberSumOfDivisorsSquared(number);
            addIfPerfectedSquared(result, number, aux);
        }
        return result;
    }

    private static void addIfPerfectedSquared(List<Integer> result, int number, long aux) {
        if(isPerfectSquare(aux)) {
            result.add(number);
        }
    }

    public static void displayStudentsOlderThan20(List<Student>students) {
        System.out.println("Students with age greater than 20:");
        for (Student student : students) {
            showIfCondtionFulfilled(student, student.getAge() > 20);
        }
    }

    private static void showIfCondtionFulfilled(Student student, boolean condition) {
        if (condition) {
            System.out.println(student);
        }
    }

    public static void displayStudentsWithLastnameEndingOfEscu(List<Student>students) {
        System.out.println("Students ending with escu:");
        for (Student student : students) {
            showIfCondtionFulfilled(student, student.getLastName().endsWith("escu"));
        }
    }

    public static void addDefaultStudentGrades(List<Student> students) {
        for (Student student : students) {
            Random random = new Random();
            List<Grades> grades = new ArrayList<>();
            grades.add(new Grades(random.nextInt(10) + 1, "Matematica"));
            grades.add(new Grades(random.nextInt(10) + 1, "Informatica"));
            grades.add(new Grades(random.nextInt(10) + 1, "Istorie"));
            student.setGrades(grades);
        }
    }

    public static boolean checkIfGradesGreaterThanFive(List<Grades> grades) {
        for(Grades grade : grades) {
            if (checkIfGradeLowerThan5(grade)) return false;
        }
        return true;
    }

    private static boolean checkIfGradeLowerThan5(Grades grade) {
        return grade.getScore() < 5;
    }

    public static void displayStudentsWithGradesAboveFive(List<Student>students) {
        for (Student student : students) {
            if(checkIfGradesGreaterThanFive(student.getGrades())) {
                System.out.println(student.getLastName());
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

        System.out.println(numberWithSquareSumOfSquareDivisorsFinder(10, 1000));
        System.out.println(numberWithSquareSumOfSquareDivisorsFinder(1000, 1500));

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
        students.sort(new StudentComparator());
        System.out.println(students);
        //TODO Display only the students that are above 20 years
        displayStudentsOlderThan20(students);
        //TODO Display only the students that have their lastname ending in escu
        displayStudentsWithLastnameEndingOfEscu(students);
        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        addDefaultStudentGrades(students);
        System.out.println(students);
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.
        displayStudentsWithGradesAboveFive(students);

        // Sort the students by age
        students = students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        // Display only the students that are above 20 years
        System.out.println("\nStudents above 20 years: ");
        students.stream().filter(x -> x.getAge() > 20).forEach(System.out::println);
        // Display only the students that have their lastname ending in escu
        System.out.println("\nStudents ending in 'escu': ");
        students.stream().filter(x -> x.getLastName().endsWith("escu")).forEach(System.out::println);
        // Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        // Add grades to the students
        addDefaultStudentGrades(students);
        // Create a method that displays the the lastName of the students that have no grade lower than 5.
        System.out.println("\nStudents with grades above 20: ");
        students.stream().filter(x -> x.getGrades().stream().allMatch(a -> a.getScore() >= 5)).
                forEach(a -> System.out.println(a.getLastName()));
    }
}
