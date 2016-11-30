package concert;

import org.springframework.stereotype.Component;

@Component
public class SomeConcert implements Performance {
    public void perform() {
        if ((int)(100 * Math.random()) % 2 == 0) {
            throw new RuntimeException();
        }
        System.out.println("bla-bla-bla");
    }
}
