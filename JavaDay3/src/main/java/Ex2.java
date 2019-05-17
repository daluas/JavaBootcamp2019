public class Ex2 {

        /*
    2-)The Ceasar cipher is a basic encryption technique used by Julius Ceasar to securely
    communicate with his generals. Each letter is replaced by another letter N positions down
    the english alphabet. Implement a decoder for the Ceasar cipher where N = 5.
    */


    public static char changeLetter(char ch, int n){

        if(Character.isUpperCase(ch)){
            ch = (char)(ch - n);
            ch = getChIfLowerThan_a(ch);

        }else if (Character.isLowerCase(ch)){
            ch = (char)(ch - n);
            ch = getChIfLowerThan_A(ch);
        }

        return ch;
    }

    public static char getChIfLowerThan_A(char ch) {
        if(ch < 'a'){
            ch = (char)(ch + 'z' - 'a' + 1);
        }
        return ch;
    }

    public static char getChIfLowerThan_a(char ch) {
        if(ch < 'A'){
            ch = (char)(ch + 'Z' - 'A' + 1);
        }
        return ch;
    }

    public static String decrypt(String code, int n){
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

        //System.out.println(changeLetter('%', 5));
        System.out.println("Ex2: " + decrypt("EXXEGOEXSRgI", 4));
    }
}
