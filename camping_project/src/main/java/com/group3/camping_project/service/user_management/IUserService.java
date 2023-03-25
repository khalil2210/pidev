package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUserService {


//    List<User> getAlUsers();
//
//    User getUser(int id);
//
//    User createUser(User user);
//
//    User createUser(User user);
//
//    User updateUser(User user);

    UserDTO getUserById(int userId);

    UserDTO createUser(UserDTO userDTO)throws EmailAlreadyExistsException;

    UserDTO updateUser(int userId, UserDTO userDTO);

    void deleteUser(int id);
    UserDTO convertToDto(User user);
    User convertToEntity(UserDTO userDTO);

}
