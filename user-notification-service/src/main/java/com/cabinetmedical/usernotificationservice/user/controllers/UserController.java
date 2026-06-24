package com.cabinetmedical.usernotificationservice.user.controllers;

import com.cabinetmedical.usernotificationservice.user.domain.User;
import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;
import com.cabinetmedical.usernotificationservice.user.services.IUserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService service;

    public UserController(
            IUserService service
    ) {

        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {

        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(
            @PathVariable int id
    ) {

        return service.getUserById(id);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(
            @PathVariable UserRole role
    ) {

        return service.getUsersByRole(role);
    }

    @PostMapping
    public boolean createUser(
            @RequestBody User user
    ) {

        return service.createUser(user);
    }

    @PutMapping
    public boolean updateUser(
            @RequestBody User user
    ) {

        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(
            @PathVariable int id
    ) {

        return service.deleteUser(id);
    }

    @PostMapping("/login")
    public User login(

            @RequestParam String username,

            @RequestParam String password
    ) {

        return service.login(
                username,
                password
        );
    }
}