package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.user_management.exception.EmailAlreadyExistsException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface IUserService {

   // String signin(String username, String password);

    String signup(User user);

    void delete(String username);

    User search(String username);

    User whoami(HttpServletRequest req);

    String refresh(String username);

    User findUserByUserName(String userName);

    User saveUser(User user);
}
