package SpringEx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

    @Around("execution(* SpringEx..*validate*(*))")
    public void execute(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("AROUND ASPECT: " + pjp.getSignature() + " has been called");

        Object[] args = pjp.getArgs(); // change the args if you want to
        Object retVal = pjp.proceed(args); // run the actual method (or don't)
        if(retVal.equals(true))
            System.out.println("Address is valid");
        else
            System.out.println("Address is not valid");
    }
}
