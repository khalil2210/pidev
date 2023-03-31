//package com.group3.camping_project.controller.user_management;
//
//import com.group3.camping_project.entities.User;
//import com.group3.camping_project.service.user_management.IUserService;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//import org.modelmapper.ModelMapper;
//import javax.servlet.http.HttpServletRequest;
//
//
//
//@RequestMapping("/users")
//@RequiredArgsConstructor
//@RestController
//public class HomeController {
//        @Autowired
//        private UserImpl userService;
//        private ModelMapper modelMapper;
//
////        @PostMapping("/signin")
////
////        public String login(//
////                            @PathVariable("Username") @RequestParam String username, //
////                            @PathVariable("Password") @RequestParam String password) {
////            return userService.signin(username, password);
////        }
//@PostMapping("/registration")
//public String createNewUser(@RequestBody User user) {
//    String msg = "";
//    User userExists = userService.findUserByUserName(user.getUsername());
//    if (userExists != null) {
//        msg = "There is already a user registered with the user name provided";
//    } else {
//        userService.saveUser(user);
//        msg = "OK";
//    }
//    return msg;
//}
//
//        @DeleteMapping(value = "/{username}")
//        //@PreAuthorize("hasRole('ROLE_ADMIN')")
//        public String delete(@PathVariable("Username") String username) {
//            userService.delete(username);
//            return username;
//        }
//
//        @GetMapping(value = "/{username}")
//        @PreAuthorize("hasRole('ROLE_ADMIN')")
//        public UserResponseDTO search(@PathVariable("Username") String username) {
//            return modelMapper.map(userService.search(username), UserResponseDTO.class);
//        }
//
//        @GetMapping(value = "/me")
//        @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
//        public UserResponseDTO whoami(HttpServletRequest req) {
//            return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
//        }
//
//        @GetMapping("/refresh")
//        @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
//        public String refresh(HttpServletRequest req) {
//            return userService.refresh(req.getRemoteUser());
//        }
//
//    }
//
////    @Autowired
////    IUserService userService;
////
////
////        @GetMapping("/{userId}")
////        public UserDTO getUserById(@PathVariable int userId) {
////            return userService.getUserById(userId);
////        }
////        @PutMapping("/{userId}")
////        public UserDTO updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
////            return userService.updateUser(userId, userDTO);
////        }
////        @DeleteMapping("/delete/{userId}")
////        public void deleteUser(@PathVariable int userId) {
////            userService.deleteUser(userId);
////        }
////    }
