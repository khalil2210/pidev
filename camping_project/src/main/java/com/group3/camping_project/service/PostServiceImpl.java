package com.group3.camping_project.service;

import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.Post;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IPostRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    public IPostRepo postRepo;
    @Autowired
    public IUserRepo userRepo;

    @Autowired
    public IImageRepo iImageRepo;

    @Override
    public Post addPost (Post post){
        filterBadWords(post);
        return postRepo.save(post);
    }
    @Override
    public Post addPostAndImage (Post post, MultipartFile image,int userId) throws IOException {

        User user = userRepo.findById(userId).get();
       post.setAuthor(user);
       filterBadWords(post);
        //if image != null
        if (image != null) {
        Image imagee = iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image.getBytes())).build());
        post.setImage(imagee);}

        System.out.println("add triggred");
        post.setCreationDate(new Date());
        return postRepo.save(post);
    }

    @Override
    public List<Post> retrieveAllPosts(){
        return  postRepo.findAll();
    }
    @Override
    public Post updatePost(Post newpost){

        Post post = postRepo.getById(newpost.getId());
        post.setTitle(newpost.getTitle());
        post.setContent(newpost.getContent() );
        post.setUpdateDate(new Date());
        filterBadWords(post);
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
        filterBadWords(post);


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


    private List<String> badWords = Arrays.asList("bad","badd","baad","badd","baaaad","baadd", "ugly","uglyy","uglyyy","uggly", "nasty", "nastyy", "nastyyy","naasty"); // list of bad words


    private void filterBadWords(Post post) {
        // Filter bad words in title
        if (post.getTitle() != null) {
            for (String word : badWords) {
                post.setTitle(post.getTitle().replaceAll("(?i)" + word, "***"));
            }
        }

        // Filter bad words in content
        if (post.getContent() != null) {
            for (String word : badWords) {
                post.setContent(post.getContent().replaceAll("(?i)" + word, "***"));
            }
        }

    }
    public List<Post> recherchePosts(String word){
        List<Post> posts = new ArrayList<>();
        for(Post post : this.retrieveAllPosts() ){
            if(post.getTitle().toLowerCase().contains(word.toLowerCase()) ||
                    post.getContent().toLowerCase().contains(word.toLowerCase()))
            {
                posts.add(post);
            }
        }
        return posts ;

    }


//     In the PostService class
//    @Override
//    @Transactional
//    public List<User> likePost(int postId, int userId) throws Exception {
//        Optional<Post> optionalPost = this.postRepo.findById(postId);
//        Optional<User> optionalUser = this.userRepo.findById(userId);
//
//        if (optionalPost.isPresent() && optionalUser.isPresent()) {
//            Post currentPost = optionalPost.get();
//            User currentUser = optionalUser.get();
//
//            if(currentPost.getLikes().contains(currentUser)) {
//                throw new Exception("You have liked this already!");
//            } else {
//                currentPost.getLikes().add(currentUser);
//                currentPost.setLikesCount(currentPost.getLikesCount() + 1);
//                this.postRepo.save(currentPost);
//                return currentPost.getLikedUsers();
//            }
//        }
//        return null;
//    }



}
