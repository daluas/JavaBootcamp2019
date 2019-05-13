public class Ex2 {

        /*
    2-)The Ceasar cipher is a basic encryption technique used by Julius Ceasar to securely
    communicate with his generals. Each letter is replaced by another letter N positions down
    the english alphabet. Implement a decoder for the Ceasar cipher where N = 5.
    */

    private static char changeLetter(char ch, int n){

        char result;
        if(Character.isUpperCase(ch)){
            result = (char)(((int)ch - n - 65)%26 + 65);
        }else{
            result = (char)(((int)ch - n - 97)%26 + 97);
        }

        return result;
    }

    private static String decrypt(String code, int n){
        int it;
        String result = "";
        char[] charCode;
        charCode = code.toCharArray();

        for(it = 0; it < charCode.length; it++){
            result = result.concat(Character.toString(changeLetter(charCode[it], n)));
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println("Ex2: " + decrypt("EXXEGOEXSRgI", 4));
    }
}
