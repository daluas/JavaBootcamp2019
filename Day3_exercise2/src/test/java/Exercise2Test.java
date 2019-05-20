import org.junit.Test;
import org.junit.jupiter.api.Assertions;
public class Exercise2Test {
    @Test
    public void testing_decoder(){
        String expected="xtrjymnsl";
        String for_test="something";
        String actual=Exercise2.decoder(for_test);
        Assertions.assertEquals(expected,actual);
    }

}
