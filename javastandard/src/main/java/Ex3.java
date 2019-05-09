public class Ex3 {

   public static String RemoveXFromString(String xString){
        return   (xString.substring(0,1) + xString.substring(1,xString.length() - 1).replaceAll("[Xx]", "") + xString.substring(xString.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(RemoveXFromString("xabxxxcdx"));
    }
}
