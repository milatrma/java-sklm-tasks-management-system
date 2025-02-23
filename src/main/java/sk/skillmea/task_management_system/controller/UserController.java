package sk.skillmea.task_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.skillmea.task_management_system.model.User;
import sk.skillmea.task_management_system.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {

        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userService.get(id));
    }


}
