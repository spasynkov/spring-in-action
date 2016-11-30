package concert;

import org.springframework.stereotype.Component;

@Component
public class DefaultPerformance implements Performance {
    public void perform() {
        System.out.println("Performing");
    }
}
