package sk.skillmea.task_management_system.service;

import sk.skillmea.task_management_system.model.Project;
import sk.skillmea.task_management_system.service.request.ProjectAddRequest;
import sk.skillmea.task_management_system.service.request.ProjectEditRequest;

import java.util.List;

public interface ProjectService {
    Project get(long id);
    List<Project> getAll();
    List<Project> getAllByUser();
    void delete (long id);

    long add(ProjectAddRequest request);
    void edit(long id, ProjectEditRequest editRequest);

}
