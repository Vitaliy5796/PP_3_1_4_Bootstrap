package ru.kata.spring.boot_security.demo.DAO;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User showUser(Long id);
    void save(User user);
    void update(User updateUser);
    void delete(Long id);
    User findByUser(String username);
}
