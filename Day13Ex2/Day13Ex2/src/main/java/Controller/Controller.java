package Controller;
import Model.Hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@org.springframework.stereotype.Controller
public class Controller {

    String[] response = {"Buna", "Hello", "Hola", "Kon'nichiwa"};


    public String afisare(Integer selectLanguage, String sayHelloTo){
        String result = "";
        result = result.concat(response[selectLanguage] + " " + sayHelloTo + "!");
        return result;
    }

    private String text = "Mvc rulz!";

    @PostMapping(value = "/simpleController")
    public @ResponseBody String getResponse(){
        return "<h1>Response</h1>";
    }

    @PostMapping(value = "/simpleController/{id}")
    public @ResponseBody String showById(@PathVariable int id){
        String raspuns = afisare(id, "Ana");

        return "<h1>" + raspuns + "</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);

    }
}
