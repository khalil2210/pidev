package com.group3.camping_project.Service;

import com.group3.camping_project.entities.Post;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IPostRepo;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    public IPostRepo postRepo;
    @Autowired
    public IUserRepo userRepo;

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
    @Override
    public Post addPostAndAssignUserById(Post post, Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("The user ID value cannot be null!!!!");
        }
        User user = userRepo.findById(userId).get();

        user.getPosts().add(post);

        post.setAuthor(user);
        return postRepo.save(post);
    }
    public List<Post> getAllPostsByUser(int userId) {
        User user = userRepo.findById(userId).get();

        if (user == null) {
            throw new IllegalArgumentException("User not found with ID " + userId);
        }

        return user.getPosts();
    }

    public List<Post> searchPosts(String authorName, String title) {
        List<Post> posts = postRepo.findAll();

        if (authorName != null) {
            posts = posts.stream()
                    .filter(p -> p.getAuthor().getFirstName().contains(authorName))
                    .collect(Collectors.toList());
        }

        if (title != null) {
            posts = posts.stream()
                    .filter(p -> p.getTitle().contains(title))
                    .collect(Collectors.toList());
        }

        return posts;
    }

}
