package com.cabinetmedical.usernotificationservice.user.infrastructure;

import com.cabinetmedical.usernotificationservice.user.domain.User;
import com.cabinetmedical.usernotificationservice.user.domain.daocontracts.IUserDAO;
import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;
import com.cabinetmedical.usernotificationservice.user.infrastructure.tableEntities.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private User mapToDomain(UserEntity e) {

        User user = new User(
                e.getId(),
                e.getUsername(),
                e.getPassword(),
                e.getEmail(),
                e.getPhone(),
                e.getRole()
        );

        user.setDoctorId(
                e.getDoctorId()
        );

        user.setPatientId(
                e.getPatientId()
        );

        user.setAssistantId(
                e.getAssistantId()
        );

        return user;
    }

    private UserEntity mapToEntity(User user) {

        UserEntity e = new UserEntity();

        if (user.getId() > 0) {

            e.setId(
                    user.getId()
            );
        }

        e.setUsername(
                user.getUsername()
        );

        e.setPassword(
                user.getPassword()
        );

        e.setEmail(
                user.getEmail()
        );

        e.setPhone(
                user.getPhone()
        );

        e.setRole(
                user.getRole()
        );

        e.setDoctorId(
                user.getDoctorId()
        );

        e.setPatientId(
                user.getPatientId()
        );

        e.setAssistantId(
                user.getAssistantId()
        );

        return e;
    }

    @Override
    public List<User> findAll() {

        List<UserEntity> list = entityManager
                .createQuery(
                        "SELECT u FROM UserEntity u",
                        UserEntity.class
                )
                .getResultList();

        return list.stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(int id) {

        UserEntity e =
                entityManager.find(
                        UserEntity.class,
                        id
                );

        return e != null
                ? mapToDomain(e)
                : null;
    }

    @Override
    public User findByUsername(String username) {

        List<UserEntity> users =
                entityManager
                        .createQuery(
                                "SELECT u FROM UserEntity u WHERE u.username = :username",
                                UserEntity.class
                        )
                        .setParameter(
                                "username",
                                username
                        )
                        .getResultList();

        if (users.isEmpty()) {

            return null;
        }

        return mapToDomain(
                users.get(0)
        );
    }

    @Override
    public List<User> findByRole(UserRole role) {

        List<UserEntity> list =
                entityManager
                        .createQuery(
                                "SELECT u FROM UserEntity u WHERE u.role = :role",
                                UserEntity.class
                        )
                        .setParameter(
                                "role",
                                role
                        )
                        .getResultList();

        return list.stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean insert(User user) {

        entityManager.persist(
                mapToEntity(user)
        );

        return true;
    }

    @Override
    public boolean update(User user) {

        entityManager.merge(
                mapToEntity(user)
        );

        return true;
    }

    @Override
    public boolean delete(int id) {

        UserEntity e =
                entityManager.find(
                        UserEntity.class,
                        id
                );

        if (e != null) {

            entityManager.remove(e);

            return true;
        }

        return false;
    }
}