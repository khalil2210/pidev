package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepo extends JpaRepository<Message,Integer> {
}
