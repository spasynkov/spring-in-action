package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

//@Repository
//@Transactional
public class HibernateSpitterRepositoryImpl implements SpitterRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        // retrieve current session from session factory
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        // use current session
        Serializable id = currentSession().save(spitter);

        return new Spitter(
                (Long) id,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession()
                .createCriteria(Spitter.class).add(Restrictions.eq("username", username)).list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
    }
}
