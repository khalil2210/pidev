package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Role;
import com.group3.camping_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
}
