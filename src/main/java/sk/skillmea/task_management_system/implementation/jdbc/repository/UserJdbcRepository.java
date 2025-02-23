package sk.skillmea.task_management_system.implementation.jdbc.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sk.skillmea.task_management_system.implementation.jdbc.mapper.UserRowMapper;
import sk.skillmea.task_management_system.model.User;

import java.util.List;

@Repository
public class UserJdbcRepository {
    private final UserRowMapper userRowMapper;
    private final JdbcTemplate jdbcTemplate;
    private final static String GET_ALL;

    static {
        GET_ALL = "SELECT * FROM user";
    }

    public UserJdbcRepository(UserRowMapper userRowMapper, JdbcTemplate jdbcTemplate) {
        this.userRowMapper = userRowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    List<User> getAll() {
        return jdbcTemplate.query(GET_ALL, userRowMapper);
    }
}
