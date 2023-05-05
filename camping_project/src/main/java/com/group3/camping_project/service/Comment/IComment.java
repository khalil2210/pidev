package com.group3.camping_project.service.Comment;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IComment {
    Comment addComment(Comment comment , MultipartFile image) throws IOException;
    Comment updateComment (Comment comment);
    List <Comment> retrieveAllComments();
    void deleteComment (int id);
    Comment assignCommentToPost(int id, String content, int authorid);
    public Comment addComment2(Comment comment,int id,int authorid) ;
    public Comment addComment1(Comment comment) throws IOException ;

    void filterBadWords(Comment comment);
    public Comment updateComment2 (Comment comment ,int id);

}
