package com.travel.reviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.reviewservice.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
