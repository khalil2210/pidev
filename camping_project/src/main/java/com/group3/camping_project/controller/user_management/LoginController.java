package com.group3.camping_project.controller.user_management;

import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.user_management.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Authenticate user and generate JWT token
        // ...

        return ResponseEntity.ok().build();
    }
}