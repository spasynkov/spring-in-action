package springinaction.deserts;

import springinaction.annotations.Cold;
import springinaction.annotations.Creamy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dinner {
    private Dessert dessert;

    public Dessert getDessert() {
        return dessert;
    }

    @Autowired
    // @Qualifier("cake")  // wiring bean by it's name/id
    // @Qualifier("crispy")    // wiring bean by qualifier set in class Cookies
    @Cold
    @Creamy
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
