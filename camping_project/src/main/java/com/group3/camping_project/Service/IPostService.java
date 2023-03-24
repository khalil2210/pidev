package com.group3.camping_project.Service;

import com.group3.camping_project.entities.Post;

import java.util.List;

public interface IPostService {
    Post addPost (Post post);
    List<Post> retrieveAllPosts();

    Post updatePost(Post post);

    Post getPostById(int id);
    void deletePost(int id);
}
