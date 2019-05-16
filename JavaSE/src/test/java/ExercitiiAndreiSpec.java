import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercitiiAndreiSpec {
    @Test
    public void should_return_nearest_to_ten(){
        int expected = 2;

        int actual = ExercitiiAndrei.nearestToTen(1,2);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void should_return_string_times(){
        String expected = "hihihi";

        String actual = ExercitiiAndrei.stringTimes("hi", 3);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void should_return_string_without_xes_in_the_middle(){
        String expected = "Mere";

        String actual = ExercitiiAndrei.stringX("Mexxxxre");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void should_return_string_with_one_x_at_first_end(){
        String expected = "xMere";
        String actual = ExercitiiAndrei.stringX("xxxxxxxxxxMere");

        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void should_return_string_with_one_x_at_second_end(){
        String expected = "Merex";
        String actual = ExercitiiAndrei.stringX("Merexxxxxxxxxx");

        Assertions.assertEquals(expected,actual);
    }

}
