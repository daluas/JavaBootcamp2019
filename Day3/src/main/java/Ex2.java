
//2-)The Ceasar cipher is a basic encryption technique used by Julius Ceasar to securely communicate with his generals. Each letter is replaced by another letter N positions down the english alphabet. For example, for a rotation of 5, the letter 'c' would be replaced by an 'h'. In case of a 'z', the alphabet rotates and it is transformed into a 'd'.
//Implement a decoder for the Ceasar cipher where N = 5.
//TIP: Use code.toCharArray() to get an array of characters.

public class Ex2 {

    private static int ASCII_CODE_UPPER_A = 65;
    private static int ASCII_CODE_UPPER_Z = 90;
    private static int ASCII_CODE_LOWER_A = 97;
    private static int ASCII_CODE_LOWER_Z = 122;

    private static char decode(char character, int n){
        int result = character - n;
        if(result <ASCII_CODE_UPPER_A)
            return (char)(result -  ASCII_CODE_UPPER_A +ASCII_CODE_UPPER_Z+1);
        if(result <ASCII_CODE_LOWER_A)
            return (char)(result - ASCII_CODE_LOWER_A + ASCII_CODE_LOWER_Z+1);
        char ret = (char)result;
        return ret;
    }

    private static String decodeCaeser(String code, int n){
        String result = "";
            for(int i=0; i<code.length();++i){
                result = result + decode(code.charAt(i),n);
            }
            return result;
    }

    public static void main(String[] args) {
        System.out.println(decodeCaeser("yjxy",5));
    }
}
