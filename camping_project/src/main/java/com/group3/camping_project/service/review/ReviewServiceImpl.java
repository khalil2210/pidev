package com.group3.camping_project.service.review;

import com.group3.camping_project.entities.*;
import com.group3.camping_project.repository.ICampingSpaceRepo;
import com.group3.camping_project.repository.IReviewRepo;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReview {
    @Autowired
    IReviewRepo reviewRepo;
    @Autowired
    ICampingSpaceRepo campingSpaceRepo;

    @Autowired
    IUserRepo userRepo;

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

    @Override
    public Review addandAssignReviewtoCampingSpace(int id, Review review,int idcampingspace ){

        User user =  userRepo.findById(id).get();
        CampingSpace campingSpace = campingSpaceRepo.findById(idcampingspace).get();

        review.setCampingSpace(campingSpace);
        review.setAuthor(user);

        return reviewRepo.save(review);
    }
}
