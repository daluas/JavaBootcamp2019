import org.omg.CORBA.StringHolder;

import java.util.ArrayList;
import java.util.List;

public class ExJava8 {

    public static String addEorO(List<Integer> intList){
        String returnString = "";

        for(Integer num:intList){
            if(num % 2 == 0){
                returnString = returnString.concat(num.toString());
                returnString = returnString.concat("e");
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

    public static char changeLetter(char c){
        int asciiC = (int) c;

        System.out.println(asciiC);

        if(asciiC > 69 && asciiC < 91){
            asciiC -= 5;
        }else if(asciiC == 65){
            asciiC += 21;
        }else if(asciiC == 66){
            asciiC += 21;
        }else if(asciiC == 67){
            asciiC += 21;
        }else if(asciiC == 68){
            asciiC += 21;
        }else if(asciiC == 69){
            asciiC += 21;
        }

        if(asciiC > 101 && asciiC < 122){
            asciiC -= 5;
        }else if(asciiC == 97){
            asciiC += 21;
        }else if(asciiC == 98){
            asciiC += 21;
        }else if(asciiC == 99){
            asciiC += 21;
        }else if(asciiC == 100){
            asciiC += 21;
        }else if(asciiC == 101){
            asciiC += 21;
        }

        c = (char) asciiC;

        return c;
    }

    public static String caesarDecoder(String code){
        int it;
        String decodedCode = "";
        char[] charCode;
        charCode = code.toCharArray();

        for(it = 0; it < charCode.length; it++){
            charCode[it] = changeLetter(charCode[it]);
        }

        for(it = 0; it < charCode.length; it++){
            decodedCode = decodedCode.concat(Character.toString(charCode[it]));
        }


        return decodedCode;
    }


    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);


        System.out.println("Ex1: " + addEorO(numList));

        System.out.println("Ex2: " + caesarDecoder("ABCDE abcde f"));
    }
}
