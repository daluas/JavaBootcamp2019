import java.util.Arrays;
import java.util.stream.Collectors;

//1-)Write a method that returns a comma separated string based on a given list of integers.
// Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
// For example, if the input list is (3,44), the output should be 'o3,e44'.


public class Ex1 {

    public static String CSVString(int[] integerList){
       return Arrays.stream(integerList).mapToObj(x -> { if(x%2==0) return "e"+String.valueOf(x); else return "o"+String.valueOf(x);}).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        int[] integerList = new int[]{3,4,5,6};
        System.out.println(CSVString(integerList));
    }
}
