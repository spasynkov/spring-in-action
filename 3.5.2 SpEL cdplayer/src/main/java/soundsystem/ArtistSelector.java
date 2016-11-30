package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class ArtistSelector {
    private String artists[] = {
            "artist 1",
            "artist 2",
            "artist 3"
    };

    public String selectArtist() {
        return artists[(int)(Math.random() * artists.length)];
    }
}
