package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @Named   // same as @Component, but from the Java Dependency Injection specification
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    /*
    * @Autowired could be use for constructors, for setters methods, and for any other methods too
    * */

    @Autowired
    // @Inject  // same as @Autowired, but from the Java Dependency Injection specification
    // @Autowired(required = false)    // spring will try to find needed bean, and if not find - it will NOT throw an exception
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void insertDisc(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
