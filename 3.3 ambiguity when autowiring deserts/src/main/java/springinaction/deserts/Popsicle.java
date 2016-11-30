package springinaction.deserts;

import springinaction.annotations.Cold;
import springinaction.annotations.Fruity;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("cold")
@Cold
@Fruity
public class Popsicle implements Dessert {
}
