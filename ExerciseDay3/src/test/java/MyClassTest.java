import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {

    @Test
    void verifyOddEven() {

        String expectedEven = "e2";
        String resultEven = MyClass.verifyOddEven(2);

        String expectedOdd = "o3";
        String resultOdd = MyClass.verifyOddEven(3);

        assertEquals(expectedEven,resultEven);
        assertEquals(expectedOdd,resultOdd);

    }

    @Test
    void evenOrOddWithElements() {

        String expectedResult = "o1, e2, o3, e4";
        String result = MyClass.evenOrOdd(Arrays.asList(1,2,3,4));

        assertEquals(expectedResult,result);

    }

    @Test
    void evenOrOddWithEmptyList(){

        String expectedEmptyString = "";
        String emptyResult = MyClass.evenOrOdd(new ArrayList<>());

        assertEquals(emptyResult,expectedEmptyString);

    }
    @Test
    void evenOrOddWithNullList(){

        String expectedNullResult ="The list is null";
        String nullResult = MyClass.evenOrOdd(null);

        assertEquals(expectedNullResult,nullResult);

    }

    @Test
    void getFormatedParityWithElements() {

        String expectedResult = "o1, e2, o3, e4";
        String result = MyClass.getFormatedParity(Arrays.asList(1,2,3,4));

        assertEquals(expectedResult,result);


    }
    @Test
    void getFormatedParityWithEmptyList() {


        String expectedEmptyString = "";
        String emptyResult = MyClass.getFormatedParity(new ArrayList<>());

        assertEquals(emptyResult,expectedEmptyString);

    }


    @Test
    void findNextLetterSpace() {

        int expectedResult = 37;
        int resutlOnSpace = MyClass.findNextLetter(32);

        assertEquals(expectedResult,resutlOnSpace);


    }
    @Test
    void findNextLetterMiddle() {

        int expectedResultMiddleLetter = 106;
        int resultMiddleLetter = MyClass.findNextLetter(101);

        assertEquals(expectedResultMiddleLetter,resultMiddleLetter);

    }
    @Test
    void findNextLetterFinal() {

        int expectedResultFinalLetter = 101;
        int resultFinalLetter = MyClass.findNextLetter(122);

        assertEquals(expectedResultFinalLetter,resultFinalLetter);

    }

    @Test
    void findPreviousLetterSpace() {

        int expectedResult = 32;
        int resutlOnSpace = MyClass.findPreviousLetter(37);

        assertEquals(expectedResult,resutlOnSpace);

    }
    @Test
    void findPreviousLetterMiddle() {

        int expectedResultMiddleLetter = 101;
        int resultMiddleLetter = MyClass.findPreviousLetter(106);

        assertEquals(expectedResultMiddleLetter,resultMiddleLetter);

    }
    @Test
    void findPreviousLetterFirst() {

        int expectedResultFinalLetter = 118 ;
        int resultFinalLetter = MyClass.findPreviousLetter(97);

        assertEquals(expectedResultFinalLetter,resultFinalLetter);

    }

    @Test
    void codeOrDecodeCesarWithNullParameter() {

        String expectedString = "Nu sunt respectate cerintele asupra stringului de input";
        String resultWithNull = MyClass.codeOrDecodeCesar(null,MyClass::findNextLetter);

        assertEquals(expectedString,resultWithNull);

    }
    @Test
    void codeOrDecodeCesarWithEmptyParameter() {

        String expectedString = "Nu sunt respectate cerintele asupra stringului de input";
        String resultWithEmpty = MyClass.codeOrDecodeCesar("",MyClass::findNextLetter);

        assertEquals(expectedString,resultWithEmpty);

    }
    @Test
    void codeOrDecodeCesarWithWrongString() {

        String expectedString = "Nu sunt respectate cerintele asupra stringului de input";
        String resultWithWrongString = MyClass.codeOrDecodeCesar("31241qfdqsqwc",MyClass::findNextLetter);

        assertEquals(expectedString,resultWithWrongString);

    }
    @Test
    void codeOrDecodeCesarWithCorespondingString() {

        String expectedString = "Fsf%fwj%rjwj%ejwt%Ejwt%BTWF";
        String resultWithCorespondingString = MyClass.codeOrDecodeCesar("Ana are mere zero Zero WORA",MyClass::findNextLetter);

        assertEquals(expectedString,resultWithCorespondingString);

    }


}