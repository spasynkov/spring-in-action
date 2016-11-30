package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Fat Faggy on 04.11.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/beans.xml");

//        context.getBean(Performance.class).perform();
//        context.getBean(Encoreable.class).performEncore();
        Performance performance = context.getBean(Performance.class);
        Encoreable encoreable = (Encoreable) performance;
        performance.perform();
        encoreable.performEncore();
    }
}
