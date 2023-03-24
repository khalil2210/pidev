package com.group3.camping_project.controller.user_management;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.user_management.IUserService;
import com.group3.camping_project.service.user_management.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;
        @GetMapping("/{userId}")
        public UserDTO getUserById(@PathVariable int userId) {
            return userService.getUserById(userId);
        }

        @PostMapping("/")
        public UserDTO createUser(@RequestBody UserDTO userDTO) {
            return userService.createUser(userDTO);
        }

        @PutMapping("/{userId}")
        public UserDTO updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
            return userService.updateUser(userId, userDTO);
        }

        @DeleteMapping("/{userId}")
        public void deleteUser(@PathVariable int userId) {
            userService.deleteUser(userId);
        }
    }

























//    @GetMapping("/")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAlUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable int id) {
//        User user = userService.getUser(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//
//    @PostMapping("/")
//    public ResponseEntity<User> createUser(@RequestBody User user)
//            {
//        User createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
//
////    @PostMapping(value = "/",consumes = {"multipart/form-data"})
////    public ResponseEntity<User> createUser(@RequestBody User user,
////                                           @RequestPart("profileImage") MultipartFile profileImage) throws IOException
////    {
////        User createdUser = userService.createUser(user, profileImage);
////        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
////    }
//
//        @PutMapping("/{id}")
//        public ResponseEntity<User> updateUser (@PathVariable int id, @RequestBody User user){
//            user.setId(id);
//            User updatedUser = userService.updateUser(user);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity<?> deleteUser (@PathVariable int id){
//            userService.deleteUser(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//}
