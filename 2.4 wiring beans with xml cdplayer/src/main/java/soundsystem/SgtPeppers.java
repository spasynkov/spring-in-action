package soundsystem;

public class SgtPeppers implements CompactDisc {
    // private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    // private String artist = "The Beatles";

    private String title;
    private String artist;

    public SgtPeppers(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
