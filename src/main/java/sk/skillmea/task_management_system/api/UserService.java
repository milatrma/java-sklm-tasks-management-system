package sk.skillmea.task_management_system.api;

import sk.skillmea.task_management_system.model.User;
import sk.skillmea.task_management_system.api.request.UserAddRequest;

import java.util.List;

//@Service
public interface UserService {
    long add(UserAddRequest request);
    void delete(long id);
    User get(long id);
    List<User> getAll();
}
