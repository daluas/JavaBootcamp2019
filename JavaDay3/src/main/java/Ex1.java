import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    /*1-)Write a method that returns a comma separated string based on a given list of integers.
    Each element should be preceded by the letter 'e' if the number is even, and preceded by the
    letter 'o' if the number is odd. For example, if the input list is (3,44), the output should be 'o3,e44'.
    */

    public static String addEorO(List<Integer> intList){
        String returnString = "";

        for(Integer num:intList){
            if(num % 2 == 0){
                returnString = returnString.concat("e");
                returnString = returnString.concat(num.toString());
                returnString = returnString.concat(",");
            }else{
                returnString = returnString.concat("o");
                returnString = returnString.concat(num.toString());
                returnString = returnString.concat(",");
            }
        }
        returnString = returnString.substring(0, returnString.length()-1);
        return returnString;
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);

        System.out.println("Ex1: " + addEorO(numList));
    }
}
