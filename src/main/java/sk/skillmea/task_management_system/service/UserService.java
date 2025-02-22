package sk.skillmea.task_management_system.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.skillmea.task_management_system.model.User;
import sk.skillmea.task_management_system.service.request.UserAddRequest;

import java.util.List;


public interface UserService {
    long add(UserAddRequest request);
    void delete(long id);
    User get(long id);
    List<User> getAll();
}
