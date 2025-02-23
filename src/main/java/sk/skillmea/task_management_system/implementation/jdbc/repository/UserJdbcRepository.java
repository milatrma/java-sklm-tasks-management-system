package sk.skillmea.task_management_system.implementation.jdbc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sk.skillmea.task_management_system.implementation.jdbc.mapper.UserRowMapper;
import sk.skillmea.task_management_system.model.User;

import java.util.List;

@Repository
public class UserJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;
//    private static final Logger logger = LoggerFactory.getLogger(UserJdbcRepository.class);
        private static final Logger logger;
//    private static final String GET_ALL = "SELECT * FROM user";
        private static final String GET_ALL;
//    private static final String GET_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String GET_BY_ID;

    static {
        logger = LoggerFactory.getLogger(UserJdbcRepository.class);
        GET_ALL = "SELECT * FROM user";
        GET_BY_ID = "SELECT * FROM user WHERE id = ?";

    }

    public UserJdbcRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
        logger.info("UserJdbcRepository initialized"); //??
    }

    public List<User> getAll() {
        return jdbcTemplate.query(GET_ALL, userRowMapper);
    }

    public User getById(Long id) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            logger.error("Error while getting user", e);
            return null;
        }
    }
}
