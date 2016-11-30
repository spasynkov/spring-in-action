package soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> songs;

    public BlankDisc(String title, String artist, List<String> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String song : songs) {
            System.out.println("Playing: " + song);
        }
    }
}
