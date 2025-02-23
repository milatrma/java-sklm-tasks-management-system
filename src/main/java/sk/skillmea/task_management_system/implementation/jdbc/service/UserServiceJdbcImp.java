package sk.skillmea.task_management_system.implementation.jdbc.service;


import org.springframework.stereotype.Service;
import sk.skillmea.task_management_system.implementation.jdbc.repository.UserJdbcRepository;
import sk.skillmea.task_management_system.model.User;
import sk.skillmea.task_management_system.service.UserService;
import sk.skillmea.task_management_system.service.request.UserAddRequest;

import java.util.List;

@Service
public class UserServiceJdbcImp implements UserService {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceJdbcImp(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    @Override
    public long add(UserAddRequest request) {
        return 0;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userJdbcRepository.getAll();
    }
}
