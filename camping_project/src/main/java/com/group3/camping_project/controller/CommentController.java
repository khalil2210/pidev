package com.group3.camping_project.controller;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.service.Comment.IComment;
import com.group3.camping_project.service.FileService.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin("http://localhost:4200")
public class CommentController {

    @Autowired
    IComment iComment;

    @Autowired
    IImageService iImageService;

    @PostMapping("/add-comment")
    public Comment AddComment(@RequestPart Comment comment, @RequestParam MultipartFile image) throws IOException {
        return (iComment.addComment(comment,image));
    }

    @GetMapping("/all-comments")
    public List<Comment> getAllComments(){
        return iComment.retrieveAllComments();
    }

    @PutMapping("/update-comment")
    public Comment UpdateComment (@RequestBody Comment comment){
        return iComment.updateComment(comment);
    }

    @DeleteMapping("/delete-comment/{id}")
    public void removeComment(@PathVariable("id") int id){
        iComment.deleteComment(id);
    }

    @PostMapping("/assigncommenttopost")
    public Comment assignCommentToPost(@RequestParam("id") int id,@RequestParam String content,@RequestParam("authorid") int authorid){
        return iComment.assignCommentToPost(id,content,authorid);
    }

    @PostMapping("/saveImageComment")
    public ResponseEntity<?> saveImage(@RequestParam MultipartFile file) throws IOException {
        Image message =iImageService.saveImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
