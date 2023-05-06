package com.group3.camping_project.service.review;

import com.group3.camping_project.entities.Review;

import java.util.List;

public interface IReview {
    public Review addReview(Review review);
    public Review updateReview (Review review);
    public List<Review> retrieveAllReviews();
    public void deleteReview (int id);
    Review addandAssignReviewtoCampingSpace(int id, Review review,int idcampingspace );
}
