package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // enables using audience bean as a proxy
@ComponentScan
public class concertJavaSpringConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean public AudienceReimplemented audienceReimplemented() {
        return new AudienceReimplemented();
    }
}
