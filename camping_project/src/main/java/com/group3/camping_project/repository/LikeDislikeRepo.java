package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.entities.LikeDislikeComment;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.entities.enums.CommentRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeDislikeRepo extends JpaRepository<LikeDislikeComment,Long> {
    LikeDislikeComment findByCommentAndUser(Comment comment, User user);
    List<LikeDislikeComment> findByUser_IdAndComment_IdAndCommentRate(int userId, int commentId, CommentRate commentRate);
}
