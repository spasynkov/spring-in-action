package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;

import java.util.List;

public interface SpitterRepository {
    long count();
    Spitter save(Spitter spitter);
    Spitter findOne(long id);
    Spitter findByUsername(String username);
    List<Spitter> findAll();
}
