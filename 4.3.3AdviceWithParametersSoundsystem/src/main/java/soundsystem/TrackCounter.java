package soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> tracksCount = new HashMap<Integer, Integer>();

    @Pointcut("execution(* soundsystem.CompactDisc.play(int))" +
            "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        tracksCount.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return tracksCount.containsKey(trackNumber)
                ?tracksCount.get(trackNumber)
                :0;
    }
}
