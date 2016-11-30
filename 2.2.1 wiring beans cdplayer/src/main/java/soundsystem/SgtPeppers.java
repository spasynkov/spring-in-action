package soundsystem;

import org.springframework.stereotype.Component;

// @Component // will create a bean with id="sgtPeppers" with lowercasing the first letter of the class name
@Component("lonelyHeartsClub")
// @Named("lonelyHeartsClub") // from Java Dependency Injection specification javax.inject
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
