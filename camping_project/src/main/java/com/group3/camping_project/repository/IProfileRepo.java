package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepo extends JpaRepository<Profile,Integer> {
}
