package SpringEx;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GeneralUtils {

    public<T> void print(T obj,Function<T,String> function){
        String string = function.apply(obj);
        System.out.print(string);  
    }
}
