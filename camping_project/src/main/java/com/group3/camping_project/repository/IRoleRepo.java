package com.group3.camping_project.repository;


import com.group3.camping_project.entities.Role;
import com.group3.camping_project.entities.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface IRoleRepo extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
    boolean existsByName(ERole name);

}
