package com.group3.camping_project.controller;


import com.group3.camping_project.entities.Review;

import com.group3.camping_project.services.IReview;
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
    public List<Review> getAllComments(){
        return iReview.retrieveAllReviews();
    }

    @PutMapping("/update-review/{id}")
    public Review updateReview (@PathVariable("id") int id, @RequestBody Review review){
        return iReview.updateReview(review);
    }

    @DeleteMapping("/delete-review/{id}")
    public void removeReview(@PathVariable("id") int id){
        iReview.deleteReview(id);
    }
}
