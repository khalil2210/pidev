package com.group3.camping_project.repository;

import com.group3.camping_project.entities.User;
import com.group3.camping_project.service.user_management.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    //User findByEmail(String email);

}

