package spittr.data;

import spittr.Spittle;
import spittr.exceptions.DuplicateSpittleException;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    void save(Spittle spittle) throws DuplicateSpittleException;
}
