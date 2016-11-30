package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;
import spittr.exceptions.DuplicateSpittleException;

import java.util.*;

import static java.lang.Thread.sleep;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    private List<Spittle> spitters = new ArrayList<Spittle>();
    private static long lastId = 0;

    public SpittleRepositoryImpl() {
        spitters.add(new Spittle("Hello world! The first ever spittle", new Date(113, 8, 2)).setId(lastId++));
        spitters.add(new Spittle("Here's another spittle", new Date(113, 9, 2)).setId(lastId++));
        spitters.add(new Spittle("Spittle spittle spittle", new Date(113, 9, 5)).setId(lastId++));
        spitters.add(new Spittle("Spittles go fourth!", new Date(116, 9, 2)).setId(lastId++));

        long time = System.currentTimeMillis();
        for (long i = spitters.size(); i < 100500; i++) {
            spitters.add(new Spittle("Spittle #" + i, new Date(time++)).setId(lastId++));
        }
    }

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> result = new ArrayList<Spittle>(
                spitters.subList(0, max < spitters.size() ? (int)max + 1 : spitters.size()));

        Collections.sort(result, new Comparator<Spittle>() {
            public int compare(Spittle o1, Spittle o2) {
                return o2.getTime().compareTo(o1.getTime());
            }
        });
        return result.subList(0, count < result.size() ? count + 1 : result.size());
    }

    public Spittle findOne(long id) {
        return spitters.get((int) id);
    }

    public void save(Spittle spittle) throws DuplicateSpittleException {
        if (spitters.contains(spittle)) {
            throw new DuplicateSpittleException();
        } else spitters.add(spittle.setId(lastId++));
    }
}
