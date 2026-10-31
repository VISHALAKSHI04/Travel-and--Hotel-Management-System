package com.travel.reviewservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.reviewservice.entity.Review;
import com.travel.reviewservice.repository.ReviewRepository;

@Service
public class Reviewservice {

    private final ReviewRepository reviewRepository;

    public Reviewservice(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id).orElse(null);

        if (existingReview == null) {
            return null;
        }

        existingReview.setUserName(review.getUserName());
        existingReview.setHotelName(review.getHotelName());
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());

        return reviewRepository.save(existingReview);
    }

    public boolean deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            return false;
        }

        reviewRepository.deleteById(id);
        return true;
    }
}
