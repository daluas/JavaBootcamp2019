import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StefanExSpec {

    @Test
    public void should_return_divisors_sum_squared() {
        long expected = 21;
        int inputNumber = 4;

        long actual = StefanEx.findNumberSumOfDivisorsSquared(inputNumber);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void should_return_divisor_squared_if_number_dived_perfectly() {
        int expected = 121;
        int inputNumber = 121;
        int inputDivisor = 11;

        long actual = StefanEx.getDivisorSquaredIfNumberDivedPerfectly(inputNumber, inputDivisor);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void should_return_true_if_number_is_perfect_square() {
        long inputNumber = 4;

        boolean result = StefanEx.isPerfectSquare(inputNumber);
        Assertions.assertTrue(result);
    }

    @Test
    public void should_return_false_if_number_is_not_perfect_square() {
        long inputNumber = 5;

        boolean result = StefanEx.isPerfectSquare(inputNumber);
        Assertions.assertFalse(result);
    }

    @Test
    public void should_return_integer_list_with_sum_of_squared_divisors() {
        int inputBegin = -3;
        int inputEnd = 0;
        List<Integer> expected = Collections.singletonList(0);

        List<Integer> result = StefanEx.numberWithSquareSumOfSquareDivisorsFinder(inputBegin, inputEnd);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void should_add_item_list_if_divisor_sum_is_perfect_squared() {
        List<Integer> inputList = new ArrayList<>();
        int inputNumber = 0;
        long inputDivisorSum = 0;
        List<Integer> expected = Collections.singletonList(0);

        StefanEx.addIfPerfectedSquared(inputList, inputNumber, inputDivisorSum);
        Assertions.assertArrayEquals(expected.toArray(), inputList.toArray());
    }

    @Test
    public void every_student_should_have_grades_size_of_3() {
        List<Student> inputList = createDefaultStudentList();

        int expected = 3;

        inputList = StefanEx.createDefaultStudentGrades(inputList);

        for(Student student:inputList)
            Assertions.assertEquals(expected, student.getGrades().size());
    }

    @Test
    public void list_should_have_the_same_size() {
        List<Student> inputList = createDefaultStudentList();

        int expected = inputList.size();

        inputList = StefanEx.createDefaultStudentGrades(inputList);

        Assertions.assertEquals(expected, inputList.size());
    }

    @Test
    public void should_return_true_if_all_grades_are_greater_than_5() {
        List<Grades> inputList = createDefaultGradesList();

        boolean result = StefanEx.checkIfGradesGreaterThanFive(inputList);

        Assertions.assertTrue(result);
    }

    public List<Student> createDefaultStudentList() {
        List<Student> inputList = new ArrayList<>();

        Student student1 = new Student(22, "Ionel", "Popescu");
        Student student2 = new Student(18, "Mihai", "Ionescu");
        Student student3 = new Student(21, "Ghita", "Muresan");
        Student student4 = new Student(17, "Dorel", "Constructor");

        inputList.add(student1);
        inputList.add(student2);
        inputList.add(student3);
        inputList.add(student4);

        return inputList;
    }

    public List<Grades> createDefaultGradesList() {
        List<Grades> grades = new ArrayList<>();
        grades.add(new Grades(7, "Matematica"));
        grades.add(new Grades(5, "Informatica"));
        grades.add(new Grades(10, "Istorie"));
        return grades;
    }
}
