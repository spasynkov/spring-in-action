package springinaction.deserts;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import springinaction.annotations.Soft;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("soft")
@Soft
public class Cake implements Dessert {
}
