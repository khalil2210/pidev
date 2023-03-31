package com.group3.camping_project.services;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements IComment{
    @Autowired
    ICommentRepo commentRepo;

    @Override
    public Comment addComment(Comment comment){
        return commentRepo.save(comment);
    }

    @Override
    public Comment updateComment (Comment comment){
        return commentRepo.save(comment);}

    @Override
    public List<Comment> retrieveAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public void deleteComment (int id){
        commentRepo.deleteById(id);
    }

}
