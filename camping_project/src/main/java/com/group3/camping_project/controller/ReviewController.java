package com.group3.camping_project.controller;


import com.group3.camping_project.entities.Review;

import com.group3.camping_project.service.Review.IReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")

public class ReviewController {


    @Autowired
    IReview iReview;

    @PostMapping("/add-review")
    public Review AddReview(@RequestBody Review review){
        return (iReview.addReview(review));
    }

    @GetMapping("/all-reviews")
    public List<Review> getAllReview(){
        return iReview.retrieveAllReviews();
    }

    @PutMapping("/update-review/{id}")
    public Review UpdateReview (@PathVariable("id") int id, @RequestBody Review review){
        return iReview.updateReview(review);
    }

    @DeleteMapping("/delete-review/{id}")
    public void removeReview(@PathVariable("id") int id){
        iReview.deleteReview(id);
    }

    @PostMapping("/addandassignreviewtocampingspace/{id}/{idcampingspace}")
    Review addandAssignReviewtoCampingSpace(@PathVariable int id,@PathVariable int idcampingspace,@RequestBody Review review ){
        return iReview.addandAssignReviewtoCampingSpace(id,review,idcampingspace);
    }
}
