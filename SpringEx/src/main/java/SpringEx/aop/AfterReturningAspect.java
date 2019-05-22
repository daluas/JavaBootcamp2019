package SpringEx.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAspect {

    @AfterReturning(pointcut ="execution(* SpringEx..*validate*(*))", returning = "ret")
    public void execute(Boolean ret) {
        System.out.println("AFTER RETURNING: " + " functia a returnat: " + ret);
    }

}
