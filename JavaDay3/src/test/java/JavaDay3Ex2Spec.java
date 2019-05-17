import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaDay3Ex2Spec {

    @Test
    public void should_return_same_character_if_it_is_not_a_letter(){
        String expected = "%";

        String actual = Character.toString(Ex2.changeLetter('%', 5));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void should_return_space_if_arg_is_space(){
        String expected = " ";
        String actual = Character.toString(Ex2.changeLetter(' ',5));

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void should_return_letter_minus_5_if_letter_not_at_the_alphabet_start(){
        String expected = "c";

        String actual = Character.toString(Ex2.changeLetter('h',5));
    }
    @Test
    public void should_return_end_alphabet_letter_if_imput_letter_at_alphabet_start(){
        String expected = "v";

        String actual  = Character.toString(Ex2.changeLetter('a', 5));

        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void should_return_ATTACKatONCE(){
        String expected = "ATTACKatONCE";

        String actual = Ex2.decrypt("EXXEGOexSRGI", 4);

        Assertions.assertEquals(expected, actual);
    }
}
