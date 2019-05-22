package SpringEx.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspect {

    @org.aspectj.lang.annotation.AfterThrowing(pointcut ="execution(* SpringEx..*validate*(*))", throwing = "ex")
    public void logException(RuntimeException ex) {
        System.out.println("AFTER THROWING: " + " functia a aruncat exceptia: " + ex.getMessage());
    }

}
