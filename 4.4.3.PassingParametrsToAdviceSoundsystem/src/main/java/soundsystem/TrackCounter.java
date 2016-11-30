package soundsystem;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {

    private Map<Integer, Integer> tracksCount = new HashMap<Integer, Integer>();

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
