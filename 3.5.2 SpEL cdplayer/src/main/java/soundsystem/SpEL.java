package soundsystem;

public class SpEL {
    private int myInt;
    private long currentTime;
    private String artistName;
    private String discTitle;
    private float pi;
    private float anotherFloat;
    private String hello;
    private boolean myBool;

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setDiscTitle(String discTitle) {
        this.discTitle = discTitle;
    }

    public void setPi(float pi) {
        this.pi = pi;
    }

    public void setAnotherFloat(float anotherFloat) {
        this.anotherFloat = anotherFloat;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void setMyBool(boolean myBool) {
        this.myBool = myBool;
    }

    @Override
    public String toString() {
        return "SpEL{" +
                "myInt=" + myInt +
                ", currentTime=" + currentTime +
                ", artistName='" + artistName + '\'' +
                ", discTitle='" + discTitle + '\'' +
                ", pi=" + pi +
                ", anotherFloat=" + anotherFloat +
                ", hello='" + hello + '\'' +
                ", myBool=" + myBool +
                '}';
    }
}
