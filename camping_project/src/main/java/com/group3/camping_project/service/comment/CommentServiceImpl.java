package com.group3.camping_project.service.comment;

import com.group3.camping_project.entities.*;
import com.group3.camping_project.entities.enums.CommentRate;
import com.group3.camping_project.repository.*;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
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
    @Autowired
    LikeDislikeRepo likeDislikeRepo;

    @Override
    public Comment addComment(Comment comment, MultipartFile image) throws IOException {
        Image image1 = iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image.getBytes())).build());
        comment.setImage(image1);
        return commentRepo.save(comment);
    }
    @Override
    public Comment addComment1(Comment comment) throws IOException {
        return commentRepo.save(comment);
    }
    @Override
    public Comment addComment2(Comment comment,int id,int authorid) {
        User user = userRepo.findById(authorid).get();
        if(id >= 0){
            Image  image= iImageRepo.findById(id).get();
            comment.setImage(image);
        }
        comment.setAuthor(user);
        filterBadWords(comment);
        return commentRepo.save(comment);
    }


    @Override
    public Comment updateComment (Comment comment){

        return commentRepo.save(comment);}
    @Override
    public Comment updateComment2 (Comment comment ,int id){
        Image  image= iImageRepo.findById(id).get();
        comment.setImage(image);

        filterBadWords(comment);
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
    private List<String> badWords = Arrays.asList("bad", "ugly", "nasty"); // list of bad words

    @Override
    public void filterBadWords(Comment comment) {
        // Filter bad words in title
        if (comment.getContent() != null) {
            for (String word : badWords) {
                comment.setContent(comment.getContent().replaceAll("(?i)" + word, "***"));
            }
        }

        // Filter bad words in content
        if (comment.getContent() != null) {
            for (String word : badWords) {
                comment.setContent(comment.getContent().replaceAll("(?i)" + word, "***"));
            }
        }
    }
    @Transactional
            public void userLikesProduct (int productId, int userId){
        User user=userRepo.findById(userId).get();
        Comment comment=commentRepo.findById(productId).get();
        LikeDislikeComment previousLike = likeDislikeRepo.findByCommentAndUser(comment, user);
        if (previousLike != null) {
            // Delete the previous like
            comment.getLikeDislikeComments().remove(previousLike);
            user.getLikeDislikeComments().remove(previousLike);
            likeDislikeRepo.delete(previousLike);
        }
        LikeDislikeComment likeDislikeComment =new LikeDislikeComment();
        likeDislikeComment.setCommentRate(CommentRate.LIKE);
        likeDislikeComment.setComment(comment);
        likeDislikeComment.setUser(user);
        likeDislikeRepo.save(likeDislikeComment);
        commentRepo.save(comment);
    } @Transactional
    public void userDislikesProduct (int productId, int userId){
        User user=userRepo.findById(userId).get();
        Comment comment=commentRepo.findById(productId).get();
        LikeDislikeComment previousLike = likeDislikeRepo.findByCommentAndUser(comment, user);
        if (previousLike != null) {
            // Delete the previous like
            comment.getLikeDislikeComments().remove(previousLike);
            user.getLikeDislikeComments().remove(previousLike);
            likeDislikeRepo.delete(previousLike);
        }
        LikeDislikeComment likeDislikeComment =new LikeDislikeComment();
        likeDislikeComment.setCommentRate(CommentRate.DISLIKE);
        likeDislikeComment.setComment(comment);
        likeDislikeComment.setUser(user);
        likeDislikeRepo.save(likeDislikeComment);
        commentRepo.save(comment);
    }

    public int numberOfLikes(int commentId){
        Comment comment=commentRepo.findById(commentId).get();
        int likes=0;
        for (LikeDislikeComment c:comment.getLikeDislikeComments()){
            if(c.getCommentRate().equals(CommentRate.LIKE)){
                likes++;
            }
        }
        return  likes;
    }
    public int numberOfDisikes(int commentId){
        Comment comment=commentRepo.findById(commentId).get();
        int dislikes=0;
        for (LikeDislikeComment c:comment.getLikeDislikeComments()){
            if(c.getCommentRate().equals(CommentRate.DISLIKE)){
                dislikes++;
            }
        }
        return  dislikes;
    }

}
