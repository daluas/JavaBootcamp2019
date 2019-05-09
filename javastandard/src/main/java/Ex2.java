public class Ex2 {

    public static String StringTimes(String string, int times){
        StringBuilder retString = new StringBuilder(string);
        while(times >1)
        {
            retString.append(string);
            --times;
        }
        return retString.toString();
    }

    public static void main(String[] args) {
        System.out.println(StringTimes("Hi",4));
    }
}
