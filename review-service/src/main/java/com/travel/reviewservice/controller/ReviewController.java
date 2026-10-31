package com.travel.reviewservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.reviewservice.entity.Review;
import com.travel.reviewservice.service.Reviewservice;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final Reviewservice reviewservice;

    public ReviewController(Reviewservice reviewservice) {
        this.reviewservice = reviewservice;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewservice.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewservice.getReviewById(id);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewservice.addReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(
            @PathVariable Long id,
            @RequestBody Review review) {
        return reviewservice.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        boolean deleted = reviewservice.deleteReview(id);

        if (deleted) {
            return "Review deleted successfully";
        }

        return "Review not found";
    }
}
