package SpringEx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {

    @Before("execution(* validateAddress(*))")
    public void execute(JoinPoint joinPoint){
        System.out.println("BEFORE ASPECT: " + joinPoint.getSignature() + " has been called");
    }
}
