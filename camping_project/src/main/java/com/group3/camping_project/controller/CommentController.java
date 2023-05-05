package com.group3.camping_project.controller;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.service.Comment.CommentServiceImpl;
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
@CrossOrigin("*")
public class CommentController {

    @Autowired
    IComment iComment;
    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    IImageService iImageService;

    @PostMapping("/add-comment")
    public Comment AddComment(@RequestPart Comment comment, @RequestParam ("file")MultipartFile image) throws IOException {
        return (iComment.addComment(comment,image));
    }
    @PostMapping("/add-comment2/{id}/{authorid}")
    public Comment AddComment2(@RequestBody Comment comment, @PathVariable("id") int id,@PathVariable("authorid") int authorid ) {
        return iComment.addComment2(comment,id,authorid);
    }
    @PostMapping("/add-comment1")
    public Comment AddComment1(@RequestBody Comment comment) throws IOException {
        return (iComment.addComment1(comment));
    }

    @GetMapping("/all-comments")
    public List<Comment> getAllComments(){
        return iComment.retrieveAllComments();
    }

    @PutMapping("/update-comment")
    public Comment UpdateComment (@RequestBody Comment comment){
        return iComment.updateComment(comment);
    }

    @PutMapping("/update-comment2/{id}")
    public Comment UpdateComment2(@RequestBody Comment comment,@PathVariable("id") int id){
        return iComment.updateComment2(comment,id);
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


    @PostMapping("{userId}/like/{idcomment}")
    public void likeProduct (@PathVariable("idcomment") int commentId,@PathVariable("userId") int userId){
        commentService.userLikesProduct(commentId,userId);
    }
    @PostMapping("{userId}/dislike/{idcomment}")
    public void dislikeProduct (@PathVariable("idcomment") int commentId,@PathVariable("userId") int userId){
        commentService.userDislikesProduct(commentId,userId);
    }
    @GetMapping("/getnbrlikes/{idcomment}")
    public int numberOfLikes(@PathVariable("idcomment") int commentId){
        return commentService.numberOfLikes(commentId);
    }
    @GetMapping("/getnbrdislikes/{idcomment}")
    public int numberOfDislikes(@PathVariable("idcomment") int commentId){
        return commentService.numberOfDisikes(commentId);
    }
}
