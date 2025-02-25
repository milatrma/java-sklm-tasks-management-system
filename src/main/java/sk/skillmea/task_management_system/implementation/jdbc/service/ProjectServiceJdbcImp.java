package sk.skillmea.task_management_system.implementation.jdbc.service;

import org.aspectj.apache.bcel.Repository;
import org.springframework.stereotype.Service;
import sk.skillmea.task_management_system.api.ProjectService;
import sk.skillmea.task_management_system.api.request.ProjectAddRequest;
import sk.skillmea.task_management_system.api.request.ProjectEditRequest;
import sk.skillmea.task_management_system.implementation.jdbc.repository.ProjectJdbcRepository;
import sk.skillmea.task_management_system.implementation.jdbc.repository.UserJdbcRepository;
import sk.skillmea.task_management_system.model.Project;

import java.util.List;

@Service
public class ProjectServiceJdbcImp implements ProjectService {
    private final ProjectJdbcRepository projectJdbcRepository;
    private final UserJdbcRepository userJdbcRepository;

    public ProjectServiceJdbcImp(ProjectJdbcRepository projectJdbcRepository, UserJdbcRepository userJdbcRepository) {
        this.projectJdbcRepository = projectJdbcRepository;
        this.userJdbcRepository = userJdbcRepository;
    }

    @Override
    public Project get(long id) {
        return projectJdbcRepository.getById(id);
    }

    @Override
    public List<Project> getAll() {
        return projectJdbcRepository.getAll();
    }

    @Override
    public List<Project> getAllByUser(long userId) {
        if (userJdbcRepository.getById(userId) != null) {
            return projectJdbcRepository.getAllByUserId(userId);
        }
        // this cannot happen because if condition above returns null, it will throw exception anyway
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long add(ProjectAddRequest request) {
        return 0;
    }

    @Override
    public void edit(long id, ProjectEditRequest editRequest) {

    }
}
