package com.cabinetmedical.usernotificationservice.user.domain.daocontracts;

import com.cabinetmedical.usernotificationservice.user.domain.User;
import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;

import java.util.List;

public interface IUserDAO {

    List<User> findAll();

    User findById(int id);

    User findByUsername(String username);

    List<User> findByRole(UserRole role);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(int id);
}