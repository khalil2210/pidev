package com.group3.camping_project.service.Comment;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.Post;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.ICommentRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IPostRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CommentServiceImpl implements IComment {
    @Autowired
    ICommentRepo commentRepo;

    @Autowired
    IUserRepo userRepo;
    @Autowired
    IPostRepo postRepo;
    @Autowired
    IImageRepo iImageRepo;

    @Override
    public Comment addComment(Comment comment, MultipartFile image) throws IOException {
        Image image1 = iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image.getBytes())).build());
        comment.setImageComment(image1);
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


    public Comment assignCommentToPost(int id, String content, int authorid) {
        Post post = postRepo.findById(id).get();
        User user = userRepo.findById(authorid).get();
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);
        comment.setAuthor(user);

        return commentRepo.save(comment);
    }

}
