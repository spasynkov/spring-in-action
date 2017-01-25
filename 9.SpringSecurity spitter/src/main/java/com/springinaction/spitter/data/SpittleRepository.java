package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spittle;
import com.springinaction.spitter.exceptions.DuplicateSpittleException;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    void save(Spittle spittle) throws DuplicateSpittleException;
}
