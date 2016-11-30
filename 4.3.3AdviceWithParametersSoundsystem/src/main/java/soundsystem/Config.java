package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public CompactDisc blankDisc() {
        BlankDisc cd = new BlankDisc();

        cd.setArtist("The Beatles");
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");

        List<String> list = new ArrayList<String>();
        list.add("Sgt. Pepper's Lonely Hearts Club Band");
        list.add("With a Little Help from My Friends");
        list.add("Lucy in the Sky with Diamonds");
        list.add("Getting Better");
        list.add("Fixing a Hole");
        list.add("Fixing a Hole6");
        list.add("Fixing a Hole7");
        list.add("Fixing a Hole8");
        cd.setTracks(list);

        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
