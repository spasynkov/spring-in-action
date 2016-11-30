package springinaction.deserts;

import springinaction.annotations.Cold;
import springinaction.annotations.Creamy;
import org.springframework.stereotype.Component;

@Component
// @Primary    // will took this bean as a default one when ambiguity occurs
// @Qualifier("cold")   // makes this bean to have a qualifier string = "cold"
@Cold
@Creamy
public class IceCream implements Dessert {
}
