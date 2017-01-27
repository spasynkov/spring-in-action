package com.springinaction.spitter.data;

import com.springinaction.spitter.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    private JdbcOperations jdbcOperations;

    private static final String INSERT_SPITTER = "insert into spitter " +
            "(username, password, firstname, lastname, email) " +
            "values(?, ?, ?, ?, ?);";

    private static final String SELECT_SPITTER_BY_ID = "SELECT * FROM spitter where id=?;";
    private static final String SELECT_SPITTER_BY_USERNAME = "SELECT * FROM spitter where username=?;";
    private static final String SELECT_ALL_SPITTERS = "SELECT * FROM spitter;";

    @Autowired
    public SpitterRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public long count() {
        return findAll().size();
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

    @Override
    public List<Spitter> findAll() {
        // TODO: check this method
        jdbcOperations.queryForObject(SELECT_ALL_SPITTERS, (rs, rowNum) -> {
            List<Spitter> list = new ArrayList<>(rowNum);
            for (int i = 0; i < rowNum; i++) {
                list.add(new Spitter(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email")));
            }
            return list;
        });
        return new ArrayList<>();
    }

    /*
    public void addSpitter(Spitter spitter) {
        String insertSpitter = "insert into spitter " +
                "(username, password, firstname, lastname, email) " +
                "VALUES (:username, :password, :firstname, :lastname, :email);";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", spitter.getUsername());
        paramMap.put("password", spitter.getPassword());
        paramMap.put("firstname", spitter.getFirstName());
        paramMap.put("lastname", spitter.getLastName());
        paramMap.put("email", spitter.getEmail());

        jdbcOperations.update(insertSpitter, paramMap);
    }
    */

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
