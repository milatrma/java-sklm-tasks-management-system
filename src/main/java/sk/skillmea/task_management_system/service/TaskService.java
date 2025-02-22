package sk.skillmea.task_management_system.service;

import sk.skillmea.task_management_system.model.Task;
import sk.skillmea.task_management_system.model.TaskStatus;
import sk.skillmea.task_management_system.service.request.TaskAddRequest;
import sk.skillmea.task_management_system.service.request.TaskEditRequest;
import sk.skillmea.task_management_system.service.request.UserAddRequest;

import java.util.List;

public interface TaskService {
    long add(TaskAddRequest request);
    void edit(long id, TaskEditRequest request);
    void changeStatus(long id, TaskStatus status);
    void assignProject(long taskId, long projectId);
    void delete(long id);
    Task get(long id);
    List<Task> getAll();
    List<Task> getAllByUserId(long userId);
    List<Task> getAllByProjectId(long projectId);
    List<Task>fetAll();



}
