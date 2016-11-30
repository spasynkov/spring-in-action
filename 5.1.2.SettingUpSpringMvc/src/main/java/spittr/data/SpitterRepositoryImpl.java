package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spitter;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    private List<Spitter> spitters = new ArrayList<Spitter>();
    private static long lastId = 0;

    public Spitter save(Spitter spitter) {
        spitter.setId(lastId++);
        spitters.add(spitter);
        return spitter;
    }

    public Spitter findByUsername(String username) {
        if (username == null) return null;

        for (Spitter spitter : spitters) {
            if (username.equals(spitter.getUsername())) return spitter;
        }
        return null;
    }
}
