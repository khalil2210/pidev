package com.group3.camping_project.controller;

import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.Post;
import com.group3.camping_project.service.FileService.IImageService;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group3.camping_project.service.IPostService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
     IPostService postService;
    @Autowired
    IImageService iImageService;




    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);    }

    @PostMapping("/addPostAndImage")
    public Post addPostAndImage(@RequestPart Post post,@RequestParam MultipartFile file,@RequestParam int userId) throws IOException {
        return postService.addPostAndImage(post,file,userId);

    }


    @GetMapping ("/allPosts")
    public List<Post> retrieveAllPosts(){
        return postService.retrieveAllPosts();
    }
    @GetMapping("/postById/{id}")
    public Post getPostById(@PathVariable("id") Integer id){
        return postService.getPostById(id);
    }
    @PutMapping("updatePost")
    public Post updtaePost(@RequestBody Post post){
        return postService.updatePost(post);
    }
    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable("id")Integer id){
        postService.deletePost(id);
    }
    @PostMapping("/addPostWithUser/{userId}")
    public Post addPostAndAssignUserById(@RequestBody Post post, @PathVariable Integer userId){
        if (userId == null) {
            throw new IllegalArgumentException("The user ID value cannot be null!!!!");
        }
        return postService.addPostAndAssignUserById(post,userId);
        }
    @GetMapping("/postsByuser/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable int userId) {
        return postService.getAllPostsByUser(userId);
    }

    @GetMapping("/postsearch")
    public List<Post> searchPosts(@RequestParam(required = false) String authorName, @RequestParam(required = false) String title) {
        return postService.searchPosts(authorName, title);
    }



    @PostMapping("/saveImagePost")
    public ResponseEntity<?> saveImage(@RequestParam MultipartFile file,@RequestPart Post post) throws IOException {
        Image message =iImageService.saveImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/getImagePost/{id}")
    public ResponseEntity<?> getImage(@PathVariable int id) throws IOException {
        byte[] image =iImageService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).
                body(image);

    }
    @GetMapping("/recherche")
    public List<Post> recherchePosts(@RequestParam String word ){
        return postService.recherchePosts(word);
    }
}

