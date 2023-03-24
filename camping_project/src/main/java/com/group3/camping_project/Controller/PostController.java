package com.group3.camping_project.Controller;

import com.group3.camping_project.entities.Post;
import com.group3.camping_project.Service.PostServiceImpl;
import com.group3.camping_project.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.group3.camping_project.Service.IPostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
     IPostService postService;
    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);    }
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
}
