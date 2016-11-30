package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlankDisc implements CompactDisc {

    private String artist;
    private String title;
    private List<String> songs;

    public BlankDisc() {
    }

    public BlankDisc(@Value("${disc.artist}") String artist,
                     @Value("${disc.title}") String title) {
        this.artist = artist;
        this.title = title;
    }

    public BlankDisc(String artist, String title, @Autowired List<String> songs) {
        this.artist = artist;
        this.title = title;
        this.songs = songs;
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

    public List<String> getSongs() {
        return songs;
    }

    @Autowired(required = false)
    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public void play() {
        System.out.println(artist + " : " + title);
        for (String song : songs) {
            System.out.println("Playing: " + song);
        }
    }
}
