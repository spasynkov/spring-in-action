package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.AnotherCircle;

/**
 * Created by Fat Faggy on 17.10.2016.
 */
public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("soundsystem");

        context.getBean(CompactDisc.class).play();

        System.out.println(context.getBean(SpEL.class));

        System.out.println(context.getBean(AnotherCircle.class));
    }
}
