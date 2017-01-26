package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    private JdbcOperations jdbcOperations;

    private static final String INSERT_SPITTER = "insert into spitter " +
            "(username, password, firstname, lastname, email) " +
            "values(?, ?, ?, ?, ?);";

    private static final String SELECT_SPITTER_BY_ID = "SELECT * FROM spitter where id=?;";
    private static final String SELECT_SPITTER_BY_USERNAME = "SELECT * FROM spitter where username=?;";

    @Autowired
    public SpitterRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public Spitter save(Spitter spitter) {
        jdbcOperations.update(INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcOperations.queryForObject(SELECT_SPITTER_BY_ID, this::mapRow, id);
    }

    public Spitter findByUsername(String username) {
        if (username == null) return null;

        return jdbcOperations.queryForObject(SELECT_SPITTER_BY_USERNAME, this::mapRow, username);
    }

    private Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Spitter(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("email"));
    }
}
