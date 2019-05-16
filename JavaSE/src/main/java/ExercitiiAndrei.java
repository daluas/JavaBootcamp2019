import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExercitiiAndrei {


    public static List<Integer> numberList = new ArrayList<Integer>();
    //First Exercise
    public static int nearestToTen(int num1, int num2){
        int dif1, dif2;
        dif1 = Math.abs(10 - num1);
        dif2 = Math.abs(10 - num2);

        if(dif1 < dif2){
            return num1;
        }else if(dif1 > dif2){
            return num2;
        }
        return 0;
    }

    //Second Exercise
    public static String stringTimes(String string, int multiply){
        String stringHelper = string;

        while (multiply > 1){
            string = string.concat(stringHelper);
            multiply--;
        }

        return string;
    }

    //Third Exercise

    public static String stringX(String string){

        return string.substring(0,1) + string.substring(1,string.length()-1).
                replaceAll("x","") +
                string.substring(string.length()-1,string.length() );

    }

    //Forth Exercise
    public static void generateList(int size){
        int toBeRemoved, it;
        Random rand = new Random();

        for(it = 1; it <= size; it++){
            numberList.add(it);
        }
        toBeRemoved = rand.nextInt(numberList.size());

        numberList.remove(toBeRemoved);
    }

    public static int findMissingNumber(int size){
        int sum1To100 = 0, sumMissingNumber = 0;

        generateList(size);

        sum1To100 = (size * (size + 1)) / 2;
        for (int num:numberList) {
            sumMissingNumber += num;
        }
        return sum1To100 - sumMissingNumber;
    }



    public static void main(String[] args) {
        System.out.println("Ex1: " + nearestToTen(9,9));

        System.out.println("Ex2: " + stringTimes("Hi", 3));

        System.out.println(("Ex3: " + stringX("xxMexxxxrexx")));

        System.out.println("Ex4: " + findMissingNumber(100));
    }
}
