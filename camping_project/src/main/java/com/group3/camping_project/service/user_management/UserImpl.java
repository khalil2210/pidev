package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements IUserService {

    @Autowired
    IUserRepo iUserRepo;


    @Override
    public List<User> getAllUsers() {
        return iUserRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return iUserRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {
        return iUserRepo.save(user);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setPassword(updatedUser.getPassword());
        return iUserRepo.save(existingUser);
    }

    @Override
    public void deleteUser(int id) {
        User existingUser = getUserById(id);
        iUserRepo.delete(existingUser);
    }

    /*public void removeUser(int id) {
        iUserRepo.deleteById(id);
    }*/
}

