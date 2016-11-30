package soundsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlankDisc implements CompactDisc {
    private String artist;
    private String title;

    public BlankDisc(
            @Value("#{systemProperties['disc.artist']}") String artist,
            @Value("#{systemProperties['disc.title']}") String title) {
        this.artist = artist;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public void play() {
        System.out.println("Playing: " + artist + " / " + title);
    }
}
