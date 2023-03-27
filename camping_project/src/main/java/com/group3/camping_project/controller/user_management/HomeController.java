package com.group3.camping_project.controller.user_management;

import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.user_management.IUserService;
import com.group3.camping_project.service.user_management.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {
    @Autowired
    IUserService userService;

    @PostMapping("/registration")
    public String createNewUser(@RequestBody User user) {
        String msg = "";
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            msg = "There is already a user registered with the user name provided";
        } else {
            userService.saveUser(user);
            msg = "OK";
        }
        return msg;
    }
        @GetMapping("/{userId}")
        public UserDTO getUserById(@PathVariable int userId) {
            return userService.getUserById(userId);
        }
        @PutMapping("/{userId}")
        public UserDTO updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
            return userService.updateUser(userId, userDTO);
        }
        @DeleteMapping("/delete/{userId}")
        public void deleteUser(@PathVariable int userId) {
            userService.deleteUser(userId);
        }
    }
