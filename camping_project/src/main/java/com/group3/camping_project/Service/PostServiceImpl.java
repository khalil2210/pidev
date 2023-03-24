package com.group3.camping_project.Service;

import com.group3.camping_project.entities.Post;
import com.group3.camping_project.repository.IPostRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    public IPostRepo postRepo;
    @Override
    public Post addPost (Post post){
        return postRepo.save(post);
    }
    @Override
    public List<Post> retrieveAllPosts(){
        return  postRepo.findAll();
    }
    @Override
    public Post updatePost(Post post){
        return postRepo.save(post);
    }
    @Override
    public Post getPostById(int id){
        return postRepo.findById(id).get();
    }
    @Override
    public void deletePost(int id){
        postRepo.deleteById(id);
    }
}
