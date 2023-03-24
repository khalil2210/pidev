package com.group3.camping_project.services;

import com.group3.camping_project.entities.Comment;

import java.util.List;

public interface IComment {
    public Comment addComment(Comment comment);
    public Comment updateComment (Comment comment);
    public List<Comment> retrieveAllComments();
    public void deleteComment (int id);
}
