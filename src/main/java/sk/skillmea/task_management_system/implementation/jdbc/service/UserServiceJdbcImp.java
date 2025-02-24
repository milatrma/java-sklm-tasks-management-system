package sk.skillmea.task_management_system.implementation.jdbc.service;


import org.springframework.stereotype.Service;
import sk.skillmea.task_management_system.implementation.jdbc.repository.UserJdbcRepository;
import sk.skillmea.task_management_system.model.User;
import sk.skillmea.task_management_system.api.UserService;
import sk.skillmea.task_management_system.api.request.UserAddRequest;

import java.util.List;

@Service
public class UserServiceJdbcImp implements UserService {
    private final UserJdbcRepository repository;

    public UserServiceJdbcImp(UserJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public long add(UserAddRequest request) {
        return repository.add(request);
    }

    @Override
    public void delete(long id) {
        if (this.get(id) != null) {
            repository.delete(id);
        }
    }

    @Override
    public User get(long id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
