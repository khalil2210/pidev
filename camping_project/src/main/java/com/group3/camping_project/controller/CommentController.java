package com.group3.camping_project.controller;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.repository.ICommentRepo;
import com.group3.camping_project.services.IComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    IComment iComment;

    @PostMapping("/add-comment")
    public Comment AddComment(@RequestBody Comment comment){
        return (iComment.addComment(comment));
    }

    @GetMapping("/all-comments")
    public List<Comment> getAllComments(){
        return iComment.retrieveAllComments();
    }

    @PutMapping("/update-comment/{id}")
    public Comment updateComment (@PathVariable("id") int id,@RequestBody Comment comment){
        return iComment.updateComment(comment);
    }

    @DeleteMapping("/delete-comment/{id}")
    public void removeComment(@PathVariable("id") int id){
        iComment.deleteComment(id);
    }
}
