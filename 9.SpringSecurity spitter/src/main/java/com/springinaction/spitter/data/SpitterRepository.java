package com.springinaction.spitter.data;

import com.springinaction.spitter.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
