import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Exercise1 {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>(Arrays.asList(3,44));
        String result=getString(list);
        System.out.println("Output: "+result);
    }
    public static String getString(List<Integer> list){
        return list.stream().map(item -> item % 2 == 0 ? "e" + item : "o" + item).collect(joining(","));
    }
}
