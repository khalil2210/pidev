package com.group3.camping_project.service.user_management;

import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserImpl implements IUserService {

    @Autowired
    private IUserRepo userRepository;

    @Override
    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        return convertToDto(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws EmailAlreadyExistsException {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }
        {
            User user = convertToEntity(userDTO);
            user.setCreationDate(new Date());
            user.setUpdateDate(new Date());
            User savedUser = userRepository.save(user);
            return convertToDto(savedUser);
        }
    }
    @Override
    public UserDTO updateUser(int userId, UserDTO userDTO) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));

        userToUpdate.setFirstName(userDTO.getFirstName());
        userToUpdate.setLastName(userDTO.getLastName());
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setPhoneNumber(userDTO.getPhoneNumber());
        userToUpdate.setGender(userDTO.getGender());
        //userToUpdate.setRole(userDTO.getRole());
        userToUpdate.setUpdateDate(new Date());
        User updatedUser = userRepository.save(userToUpdate);
        return convertToDto(updatedUser);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setGender(user.getGender());
        //userDTO.setRole(user.getRole());
        userDTO.setCreationDate(user.getCreationDate());
        userDTO.setUpdateDate(user.getUpdateDate());
        //userDTO.setProfileImage(user.getProfileImage());
        return userDTO;
    }


@Override
public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setGender(userDTO.getGender());
        //user.setRole(userDTO.getRole());
        return user;
    }

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        return userRepository.save(user); }
}

























//@Service
//public class UserImpl implements IUserService {
//
//    @Autowired
//    IUserRepo iUserRepo ;
//
//    @Override
//    public List<User> getAlUsers() {
//        return iUserRepo.findAll() ;
//    }
//
//    @Override
//    public User getUser(int id) {
//        return iUserRepo.findById(id).get();
//    }
//
//    @Override
//    public User createUser(User user) {
//        return iUserRepo.save(user);
//    }
////    @Override
////    public User createUser(User user, MultipartFile profileImage) throws IOException {
////        if (profileImage != null && !profileImage.isEmpty()) {
////            Image image = new Image();
////            image.setImageData(profileImage.getBytes());
////            user.setProfileImage(image);
////        }
////        return iUserRepo.save(user);
////    }
//
//
//    @Override
//    public User updateUser(User user){
//        return iUserRepo.save(user);
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        iUserRepo.deleteById(id);
//    }
//}