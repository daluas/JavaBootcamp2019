import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise3Test {
    @Test
    public void testing_uppercase_strings(){
        List<String> for_test = Arrays.asList("hi", "hello","hey","bye");
        String expected="HIHELLOHEYBYE";
        String actual =Exercise3.uppercase1(for_test);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testing_length_of_strings(){
        List<String> for_test = Arrays.asList("hi", "hello","hey","bye");
        String expected="13";
        String actual =Exercise3.length_of_strings(for_test);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testing_number_of_words_containing_h(){
        List<String> for_test = Arrays.asList("hi", "hello","hey","bye");
        String expected="3";
        String actual =Exercise3.number_of_words_containing_h(for_test);
        Assertions.assertEquals(expected, actual);
    }

}
