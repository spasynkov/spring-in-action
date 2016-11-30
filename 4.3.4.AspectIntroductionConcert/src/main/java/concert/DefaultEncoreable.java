package concert;

import org.springframework.stereotype.Component;

@Component
public class DefaultEncoreable implements Encoreable {
    public void performEncore() {
        System.out.println("Encore!");
    }
}
