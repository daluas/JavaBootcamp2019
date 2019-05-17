import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StefanExTest {

    @Test
    public void should_return_divisors_sum_squared(){
        long expected = 21;
        int parameter = 4;

        long actual = StefanEx.findNumberSumOfDivisorsSquared(parameter);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void should_return_divisors_sum_zero_if_input_is_zero(){
        long expected = 0;
        int parameter = 0;

        long actual = StefanEx.findNumberSumOfDivisorsSquared(parameter);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void should_return_divisors_sum_one_if_input_is_one(){
        long expected = 1;
        int parameter = 1;

        long actual = StefanEx.findNumberSumOfDivisorsSquared(parameter);

        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void should_return_true_if_number_is_perfect_square(){
        int parameter = 4;
        boolean result = StefanEx.isPerfectSquare(parameter);
        Assertions.assertTrue(result);
    }

    @Test
    public void should_return_false_if_number_is_not_perfect_square(){
        int parameter = 3;
        boolean result = StefanEx.isPerfectSquare(parameter);
        Assertions.assertFalse(result);
    }

    @Test
    public void should_return_numbers_whose_sum_of_divisors_are_perfect_squares(){
        List<Integer> actual = StefanEx.numberWithSquareSumOfSquareDivisorsFinder(10,1000);
        List<Integer> expected = Arrays.asList(42, 246, 287, 728);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void should_return_all_students_whose_age_is_over_20(){

        List<Student> parameter = new ArrayList<Student>()
            {{
                add(new Student(22, "Ionel", "Popescu"));
                add(new Student(18, "Mihai", "Ionescu"));
                add(new Student(21, "Ghita", "Muresan"));
                add(new Student(17, "Dorel", "Constructor"));
            }};
        List<Student> actual = StefanEx.returnStudentsOlderThan20(parameter);
        List<Student> expected = new ArrayList<Student>() {{
            add(new Student(22, "Ionel", "Popescu"));
            add(new Student(21, "Ghita", "Muresan"));
        }};
        Assertions.assertEquals(expected,actual,"Result has students whose age is under 20");
    }

   /* @Test(expected = NullPointerException.class)
    public void should_retun_null_pointer_exception_if_returnStudentsOlderThan20_receives_an_empty_list(){
        List<Student> parameter = null;
        List<Student> actual = StefanEx.returnStudentsOlderThan20(parameter);
        Assertions.assertEquals(expected,actual);
    }*/

    @Test
    public void should_retun_null_pointer_exception_if_returnStudentsOlderThan20_receives_an_empty_list2(){
        List<Student> parameter = null;
        assertThrows(NullPointerException.class, () ->
            StefanEx.returnStudentsOlderThan20(parameter));
    }




    @Test
    public void should_return_all_students_whose_last_name_ends_in_escu(){

        List<Student> parameter = new ArrayList<Student>()
        {{
            add(new Student(22, "Ionel", "Popescu"));
            add(new Student(18, "Mihai", "Ionescu"));
            add(new Student(21, "Ghita", "Muresan"));
            add(new Student(17, "Dorel", "Constructor"));
        }};
        List<Student> actual = StefanEx.getStudentsWithLastnameEndingOfEscu(parameter);
        List<Student> expected = new ArrayList<Student>() {{
            add(new Student(22, "Ionel", "Popescu"));
            add(new Student(18, "Mihai", "Ionescu"));
        }};
        Assertions.assertEquals(expected,actual,"Return list has students that don't end in escu");
    }

    @Test
    public void should_return_true_if_all_grades_are_greater_than_five()
    {
        List<Grades> grades = new ArrayList<Grades>(){
            {
                add(new Grades(7, "Matematica"));
                add(new Grades(8, "Informatica"));
                add(new Grades(5, "Istorie"));
            }};
        boolean result = StefanEx.checkIfGradesGreaterThanFive(grades);
        Assertions.assertTrue(result);
    }

    @Test
    public void should_return_false_if_some_grades_are_lower_than_five()
    {
        List<Grades> grades = new ArrayList<Grades>(){
            {
                add(new Grades(4, "Matematica"));
                add(new Grades(8, "Informatica"));
                add(new Grades(5, "Istorie"));
            }};
        boolean result = StefanEx.checkIfGradesGreaterThanFive(grades);
        Assertions.assertFalse(result);
    }

    @Test
    public void should_return_all_students_last_name_whose_grades_are_over_five(){

        List<Grades> gradesS1 = new ArrayList<Grades>(){
            {
                add(new Grades(4, "Matematica"));
                add(new Grades(8, "Informatica"));
                add(new Grades(5, "Istorie"));
            }};
        Student s1 = new Student(18, "Mihai", "Ionescu");
        List<Grades> gradesS2 = new ArrayList<Grades>(){
            {
                add(new Grades(5, "Matematica"));
                add(new Grades(8, "Informatica"));
                add(new Grades(5, "Istorie"));
            }};
        Student s2 = new Student(21, "Ghita", "Muresan");
        List<Grades> gradesS3 = new ArrayList<Grades>(){
            {
                add(new Grades(10, "Matematica"));
                add(new Grades(8, "Informatica"));
                add(new Grades(5, "Istorie"));
            }};
        Student s3 = new Student(17, "Dorel", "Munteanu");

        s1.setGrades(gradesS1);
        s2.setGrades(gradesS2);
        s3.setGrades(gradesS3);

        List<Student> parameter = Arrays.asList(s1, s2, s3);

        List<String> actual = StefanEx.getStudentsLastNameWithGradesAboveFive(parameter);
        List<String> expected = Arrays.asList("Muresan","Munteanu");
        Assertions.assertEquals(expected,actual,"");
    }


}
