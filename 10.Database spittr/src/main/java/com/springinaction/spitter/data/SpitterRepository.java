package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
