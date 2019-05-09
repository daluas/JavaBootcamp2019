import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex4 {

    public static Integer removedElem = null;
    public static final Integer SUM_FIRST_100_INTS = 5050; //n(n+1)/2


    public static List<Integer> GetIntegerList(){
        List<Integer> integerList = new ArrayList<>();
        Random rand = new Random();
        removedElem = rand.nextInt(100);
        for(Integer elem=1; elem<=100;++elem) {
            if(!elem.equals(removedElem)) {
                integerList.add(elem);
            }
        }
        Collections.shuffle(integerList);
        return integerList;

    }

    public static Integer GetMissingInteger(List<Integer> integerList) {
        Integer integerSum = integerList.stream().reduce(0, Integer::sum);
        return (SUM_FIRST_100_INTS - integerSum);
    }



    public static void main(String[] args) {

        List<Integer> testList = new ArrayList<>();
        testList = GetIntegerList();
        Integer missingNumber = GetMissingInteger(testList);
        System.out.println("Determined missing number is " + missingNumber);
        System.out.println("Actual missing number is " + removedElem);
    }
}