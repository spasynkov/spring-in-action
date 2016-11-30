package soundsystem;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlankDisc implements CompactDisc {

    private String artist;
    private String title;
    private List<String> tracks;

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing: " + artist + " / " + title);
        for (int i = 0; i < tracks.size(); i++) {
            play(i);
        }
    }

    public void play(int trackNumberToPlay) {
        System.out.println("Track: " + tracks.get(trackNumberToPlay));
    }
}
