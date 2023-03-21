package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepo extends JpaRepository<Video,Integer> {
}
