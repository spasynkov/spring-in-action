package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
@ImportResource("classpath:/META-INF/spring/blankDisc.xml")
public class SoundSystemConfig {
}
