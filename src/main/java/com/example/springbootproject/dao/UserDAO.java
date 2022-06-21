package com.example.springbootproject.dao;

import com.example.springbootproject.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);
}
