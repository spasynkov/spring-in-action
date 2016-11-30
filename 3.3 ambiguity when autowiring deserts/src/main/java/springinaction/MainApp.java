package springinaction;

import springinaction.deserts.Dinner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Fat Faggy on 14.10.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Dinner dinner = context.getBean(Dinner.class);
        System.out.println(dinner.getDessert());
    }
}
