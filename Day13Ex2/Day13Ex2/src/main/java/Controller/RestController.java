package Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    private String[] response = {"Buna", "Hello", "Hola", "Kon'nichiwa", "Yo", "Ola", "Hi"};


    private String afisare(String idish){
        String result = "";
        String id = idish.substring(0,1);
        String nume = idish.substring(1,idish.length());
        Integer idInt = Integer.parseInt(id);

        result = result.concat(response[idInt] + " " + nume + "!");
        return result;
    }

    private String text = "Mvc rulz!";

    @PostMapping(value = "/RestController")
    public String getResponse(){
        return "<h1>Response Rest Controller</h1>";
    }

    @PostMapping(value = "/RestController/{id}")
    public String showById(@PathVariable String id){
        String raspuns = afisare(id);

        return "<h1>" + raspuns + "</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);

    }
}
