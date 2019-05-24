package Model;

public class Hello {
    String[] language = {"Romanian", "English", "Spanish", "Japanese"};
    String[] response = {"Buna", "Hello", "Hola", "Kon'nichiwa"};


    public String afisare(Integer selectLanguage, String sayHelloTo){
        String result = "";
        result = result.concat(language[selectLanguage] + " " + sayHelloTo + "!");
        return result;
    }

}
