public class Exercise2 {

    public static void main(String args[]){
        String code="something";
        String result=decoder(code);
        System.out.println("Output: "+result);
    }
    public static String decoder(String code){
        String result = "";
        char[] converted_char=code.toCharArray();
        for (int i=0; i < converted_char.length; i++) {
            int number_of_positions = converted_char[i] + 5;
            if(number_of_positions<'z'){
                result=result+(char)number_of_positions;
            }
            else {
                result=result+(char)(number_of_positions-('z'-'a'+1));
            }
        }
        return result;
    }
}
