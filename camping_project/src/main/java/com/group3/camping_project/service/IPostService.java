package com.group3.camping_project.service;

import com.group3.camping_project.entities.Post;
import com.group3.camping_project.entities.User;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public interface IPostService {
    Post addPost (Post post);

    Post addPostAndImage (Post post, MultipartFile file,int userId) throws IOException;


    List<Post> retrieveAllPosts();

    Post updatePost(Post post);

    Post getPostById(int id);
    void deletePost(int id);
    Post addPostAndAssignUserById(Post post, Integer userId);
    public List<Post> getAllPostsByUser(int userId) ;
    public List<Post> searchPosts(String authorName, String title) ;
    public List<Post> recherchePosts(String word);


    // In the PostService class
//    @Transactional
//    List<User> likePost(int postId, int userId) throws Exception;
}
