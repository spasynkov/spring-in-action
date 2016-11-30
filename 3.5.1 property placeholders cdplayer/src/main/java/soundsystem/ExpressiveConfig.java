package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/soundsystem/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment environment;

    // configuring placeholders bean to work with properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CompactDisc blankDisc() {
        // getting values by different (from String) class and using default value 500
        System.out.println(environment.getProperty("some.number", Integer.class, 500));

        // if we need to resolve a property into a Class
        // Class<CompactDisc> cdClass = environment.getPropertyAsClass("disc.class", CompactDisc.class);

        // if values aren't specified then use default values
        // if the value is specified but not defined then we will get null here
        return new BlankDisc(
                environment.getProperty("disc.artist", "Unknown artist"),
                environment.getProperty("disc.title", "Unknown title"));

        /*
        // we could check if some value exists
        if (
                environment.containsProperty("disc.artist") &&
                environment.containsProperty("disc.title")
                ) {
            // if we want to get the notnull value of the property we will use this.
            // if value is null then IllegalStateException would be thrown
            return new BlankDisc(
                    environment.getRequiredProperty("disc.artist"),
                    environment.getRequiredProperty("disc.title")
            );
        } else {
            return new BlankDisc("Unknown artist", "Unknown title");
        }
        */
    }
}
