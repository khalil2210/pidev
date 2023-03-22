package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);

    User updateUser(int id, User updatedUser);

    void deleteUser(int id);
}
