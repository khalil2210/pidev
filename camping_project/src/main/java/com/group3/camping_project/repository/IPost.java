package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPost extends JpaRepository<Post,Integer> {
}
