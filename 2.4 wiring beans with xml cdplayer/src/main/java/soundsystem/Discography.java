package soundsystem;

import java.util.List;

public class Discography {
    private String artist;
    private List<CompactDisc> discs;

    public Discography(String artist, List<CompactDisc> discs) {
        this.artist = artist;
        this.discs = discs;
    }
}
