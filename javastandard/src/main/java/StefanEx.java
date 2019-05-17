import java.util.*;
import java.util.stream.Collectors;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

public class  StefanEx {

    public static long findNumberSumOfDivisorsSquared(int number) {
        if(number == 1 || number == -1)
            return 1;
        if(number == 0)
            return 0;
        long sum = 1;
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                sum += i*i;
            }
        }
        sum += number*number;
        return sum;
    }

    public static boolean isPerfectSquare(long number) {
        double sqrt = Math.sqrt(number);
        return (sqrt - Math.floor(sqrt)) == 0;
    }

    public static List<Integer> numberWithSquareSumOfSquareDivisorsFinder(int begin, int end) {
        List<Integer> result = new ArrayList<>();
        for(int number = begin; number <= end; number++) {
            long aux = findNumberSumOfDivisorsSquared(number);
            if(isPerfectSquare(aux)) {
                result.add(number);
            }
        }
        return result;
    }

    public static List<Student> returnStudentsOlderThan20(List<Student>students) {
        List<Student> over20Students = new ArrayList<>();
        for (Student student : students) {
            if(student.getAge() > 20) {
                over20Students.add(student);
            }
        }
        return over20Students;
    }

    public static List<Student> getStudentsWithLastnameEndingOfEscu(List<Student>students) {
        List<Student> escuStudents = new ArrayList<>();
        for (Student student : students) {
            if(student.getLastName().endsWith("escu")) {
                escuStudents.add(student);
            }
        }
        return escuStudents;
    }

    private static void addDefaultStudentGrades(List<Student> students) {
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
            if(grade.getScore() < 5) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getStudentsLastNameWithGradesAboveFive(List<Student>students) {
        List<String> aboveFiveStudentsNames = new ArrayList<>();
        for (Student student : students) {
            if(checkIfGradesGreaterThanFive(student.getGrades())) {
                aboveFiveStudentsNames.add(student.getLastName());
            }
        }
        return aboveFiveStudentsNames;
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
        List<Student> over20Students = returnStudentsOlderThan20(students);
        //TODO Display only the students that have their lastname ending in escu
        List<Student> escuStudents = getStudentsWithLastnameEndingOfEscu(students);
        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        addDefaultStudentGrades(students);
        System.out.println(students);
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.
        List<String> aboveFiveStudentNames = getStudentsLastNameWithGradesAboveFive(students);

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
