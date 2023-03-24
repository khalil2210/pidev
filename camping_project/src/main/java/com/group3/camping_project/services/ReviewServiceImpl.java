package com.group3.camping_project.services;

import com.group3.camping_project.entities.Comment;
import com.group3.camping_project.entities.Review;
import com.group3.camping_project.repository.ICommentRepo;
import com.group3.camping_project.repository.IReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReview{
    @Autowired
    IReviewRepo reviewRepo;

    @Override
    public Review addReview(Review review){
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview (Review review){
        return reviewRepo.save(review);}

    @Override
    public List<Review> retrieveAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public void deleteReview (int id){
        reviewRepo.deleteById(id);
    }

}
