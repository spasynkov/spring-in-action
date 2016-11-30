package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc SgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    // bean id = "randomBeatlesCD"
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);

        switch (choice) {
            case 1: {
                return new SgtPeppers();
            }
            case 2: {
                return new SgtPeppers();
            }
            case 3: {
                return new SgtPeppers();
            }
            default: {
                return new SgtPeppers();
            }
        }
    }

    @Bean
    // bean id = "cdPlayer" as method's name
    public MediaPlayer cdPlayer() {
        return new CDPlayer(SgtPeppers());
    }

    @Bean
    public MediaPlayer anotherCDPlayer(CompactDisc lonelyHeartsClubBand) {
        return new CDPlayer(lonelyHeartsClubBand);
    }

    @Bean
    public CDPlayer thirdCDPlayer(CompactDisc randomBeatlesCD) {
        CDPlayer cdPlayer = new CDPlayer(randomBeatlesCD);
        cdPlayer.setCd(randomBeatlesCD);    // hope we change disc here with random one
        return cdPlayer;
    }
}
