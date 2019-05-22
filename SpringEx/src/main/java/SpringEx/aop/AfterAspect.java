package SpringEx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {

    @After("execution(* validateAddress(*))")
    public void execute(JoinPoint joinPoint){
        System.out.println("AFTER ASPECT: " + joinPoint.getSignature() + " has been executed");
    }
}
