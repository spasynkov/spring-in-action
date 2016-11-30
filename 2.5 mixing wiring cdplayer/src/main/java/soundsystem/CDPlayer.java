package soundsystem;

public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CDPlayer() {
    }

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
