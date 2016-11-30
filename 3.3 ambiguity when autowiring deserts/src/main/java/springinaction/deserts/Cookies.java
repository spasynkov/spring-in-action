package springinaction.deserts;

import springinaction.annotations.Crispy;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("crispy")
@Crispy
public class Cookies implements Dessert {
}
