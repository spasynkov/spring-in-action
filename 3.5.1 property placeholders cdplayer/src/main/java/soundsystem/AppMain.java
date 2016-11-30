package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);

        CompactDisc disc = context.getBean(CompactDisc.class);
        disc.play();
    }
}
