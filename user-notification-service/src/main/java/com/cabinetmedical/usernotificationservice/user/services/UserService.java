package com.cabinetmedical.usernotificationservice.user.services;

import com.cabinetmedical.usernotificationservice.user.domain.User;
import com.cabinetmedical.usernotificationservice.user.domain.daocontracts.IUserDAO;
import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
        implements IUserService {

    private final IUserDAO userDAO;

    public UserService(
            IUserDAO userDAO
    ) {

        this.userDAO = userDAO;
    }

    // ADMIN

    @Override
    public List<User> getAllUsers() {

        return userDAO.findAll();
    }

    @Override
    public User getUserById(
            int id
    ) {

        return userDAO.findById(id);
    }

    @Override
    public List<User> getUsersByRole(
            UserRole role
    ) {

        return userDAO.findByRole(role);
    }

    @Override
    public boolean createUser(
            User user
    ) {

        if (user == null) {
            return false;
        }

        if (
                user.getUsername() == null
                        ||
                        user.getUsername().isEmpty()
        ) {

            return false;
        }

        if (
                user.getPassword() == null
                        ||
                        user.getPassword().length() < 4
        ) {

            return false;
        }

        if (
                userDAO.findByUsername(
                        user.getUsername()
                ) != null
        ) {

            return false;
        }

        return userDAO.insert(user);
    }

    @Override
    public boolean updateUser(
            User user
    ) {

        User existingUser =
                userDAO.findById(
                        user.getId()
                );

        if (existingUser == null) {
            return false;
        }

        return userDAO.update(user);
    }

    @Override
    public boolean deleteUser(
            int id
    ) {

        User existingUser =
                userDAO.findById(id);

        if (existingUser == null) {
            return false;
        }

        return userDAO.delete(id);
    }

    // AUTHENTICATION

    @Override
    public User login(
            String username,
            String password
    ) {

        User user =
                userDAO.findByUsername(
                        username
                );

        if (user == null) {
            return null;
        }

        if (
                !user.getPassword()
                        .equals(password)
        ) {

            return null;
        }

        return user;
    }
}