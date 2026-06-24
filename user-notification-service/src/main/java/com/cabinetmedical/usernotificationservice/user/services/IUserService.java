package com.cabinetmedical.usernotificationservice.user.services;

import com.cabinetmedical.usernotificationservice.user.domain.User;
import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int id);

    List<User> getUsersByRole(
            UserRole role
    );

    boolean createUser(
            User user
    );

    boolean updateUser(
            User user
    );

    boolean deleteUser(
            int id
    );

    User login(
            String username,
            String password
    );
}