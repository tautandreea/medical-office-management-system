package com.cabinetmedical.usernotificationservice.user.services;

import com.cabinetmedical.usernotificationservice.user.domain.User;
import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import java.util.List;

@Primary
@Service
public class UserServiceProxy
        implements IUserService {

    private final UserService userService;

    public UserServiceProxy(
            UserService userService
    ) {

        this.userService = userService;
    }

    @Override
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @Override
    public User getUserById(
            int id
    ) {

        if(id <= 0) {
            return null;
        }

        return userService.getUserById(id);
    }

    @Override
    public List<User> getUsersByRole(
            UserRole role
    ) {

        return userService.getUsersByRole(role);
    }

    @Override
    public boolean createUser(User user) {

        if(user == null) {
            return false;
        }

        // validare email

        if(
                user.getEmail() == null ||

                        !user.getEmail().contains("@")
        ) {

            return false;
        }

        // validare telefon

        if(
                user.getPhone() == null ||

                        user.getPhone().length() < 10
        ) {

            return false;
        }

        return userService.createUser(user);
    }

    @Override
    public boolean updateUser(User user) {

        if(user == null) {
            return false;
        }

        if(
                user.getEmail() == null ||

                        !user.getEmail().contains("@")
        ) {

            return false;
        }

        if(
                user.getPhone() == null ||

                        user.getPhone().length() < 10
        ) {

            return false;
        }

        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(
            int id
    ) {

        if(id <= 0) {
            return false;
        }

        return userService.deleteUser(id);
    }

    @Override
    public User login(
            String username,
            String password
    ) {

        if(username == null
                || username.isBlank()) {

            return null;
        }

        if(password == null
                || password.isBlank()) {

            return null;
        }

        return userService.login(
                username,
                password
        );
    }
}