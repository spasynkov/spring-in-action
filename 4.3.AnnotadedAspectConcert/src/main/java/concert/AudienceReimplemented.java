package concert;

import org.aspectj.apache.bcel.generic.ObjectType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AudienceReimplemented {

    // named pointcut to use in before/after sections
    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance(){
        // this method is just a marker
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            System.out.println("Demand a refund");
        }
    }
}
