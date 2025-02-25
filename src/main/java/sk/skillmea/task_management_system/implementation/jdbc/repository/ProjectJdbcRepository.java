package sk.skillmea.task_management_system.implementation.jdbc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sk.skillmea.task_management_system.api.exception.InternalErrorException;
import sk.skillmea.task_management_system.api.exception.ResourceNotFoundException;
import sk.skillmea.task_management_system.implementation.jdbc.mapper.ProjectRowMapper;
import sk.skillmea.task_management_system.model.Project;

import java.util.List;

@Repository
public class ProjectJdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProjectRowMapper rowMapper;

    private static final Logger logger;
    private static final String GET_ALL;
    private static final String GET_BY_ID;
    private static final String GET_ALL_BY_USER;

    static {
        LoggerFactory.getLogger(ProjectJdbcRepository.class);
        GET_ALL = "SELECT * FROM project";
        GET_BY_ID = "SELECT * FROM project WHERE id = ?";
        GET_ALL_BY_USER = "SELECT * FROM project WHERE user_id = ?";
    }


    public ProjectJdbcRepository(JdbcTemplate jdbcTemplate, ProjectRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public List<Project> getAll(){
        try {
            return jdbcTemplate.query(GET_ALL, rowMapper);
        } catch (DataAccessException e) {
            logger.error("Error while getting all projects", e);
            throw new InternalErrorException("Error while getting all projects");
        }
    }

    public Project getById (long id) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_ID, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Project with id: " + id + " was not found");
        } catch (DataAccessException e) {
            logger.error("Problem with getById project", e);
            throw new InternalErrorException("Problem with getById project");
        }
    }

    public List<Project> getAllByUserId (long userId) {
        try {
            return jdbcTemplate.query(GET_ALL_BY_USER, rowMapper, userId);
        } catch (DataAccessException e) {
            logger.error("Error while getting all projects by user id");
            throw new InternalErrorException("Error while getting all projects by user id");
        }
    }

}
