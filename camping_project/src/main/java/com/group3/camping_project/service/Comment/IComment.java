package com.group3.camping_project.service.Comment;

import com.group3.camping_project.entities.Comment;

import java.util.List;

public interface IComment {
    Comment addComment(Comment comment);
    Comment updateComment (Comment comment);
    List<Comment> retrieveAllComments();
    void deleteComment (int id);
    Comment assignCommentToPost(int id, String content, int authorid);


}
