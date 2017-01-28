package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Spitter save(Spitter spitter) {
        entityManagerFactory.createEntityManager().persist(spitter);
        return spitter;
    }

    @Override
    public Spitter findOne(long id) {
        return entityManagerFactory.createEntityManager().find(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
