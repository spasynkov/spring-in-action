package concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    // named pointcut to use in before/after sections
    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance(){
        // this method is just a marker
    }

    // before performance
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silent cell phones");
    }

    // before performance
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    // after performance
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    // after bad performance
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
