package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findOne(long id);
    Spitter findByUsername(String username);
}
