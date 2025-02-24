package sk.skillmea.task_management_system.implementation.jdbc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sk.skillmea.task_management_system.api.exception.BadRequestException;
import sk.skillmea.task_management_system.api.exception.InternalErrorException;
import sk.skillmea.task_management_system.api.exception.ResourceNotFoundException;
import sk.skillmea.task_management_system.api.request.UserAddRequest;
import sk.skillmea.task_management_system.implementation.jdbc.mapper.UserRowMapper;
import sk.skillmea.task_management_system.model.User;

import java.sql.PreparedStatement;
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
    private static final String INSERT;

    static {
        logger = LoggerFactory.getLogger(UserJdbcRepository.class);
        GET_ALL = "SELECT * FROM user";
        GET_BY_ID = "SELECT * FROM user WHERE id = ?";
        INSERT = "INSERT INTO user(id,name,email) VALUES (next value for user_id_seq,?,?)";

    }

    public UserJdbcRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    public long add(UserAddRequest request) {
        try {
            final KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                final PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, request.getName());
                ps.setString(2, request.getEmail());
                return ps;
            }, keyHolder);

            if (keyHolder.getKey() == null) {
                logger.error("KeyHolder is null");
                throw new InternalErrorException("Error while adding user");
            }
            return keyHolder.getKey().longValue();
        } catch (DataIntegrityViolationException e) {  // email already exists => is not unique
            throw new BadRequestException("User with email: " + request.getEmail() + " already exists");
        } catch (DataAccessException e) {
             logger.error("Error while adding user");
             throw new InternalErrorException("Error while adding user");
        }
    }


    public List<User> getAll() {
        return jdbcTemplate.query(GET_ALL, userRowMapper);
    }

    public User getById(long id) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User with id " + id + " was not found.");
        } catch (DataAccessException e) {
            logger.error("Error while getting user", e);
            throw new InternalErrorException("Error while getting user by id.");
        }
    }
}
