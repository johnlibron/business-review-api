package com.crescendo.service;

import com.crescendo.model.Review;
import com.crescendo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewServiceImpl implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void createBusinessReview(Review newReview) {
        reviewRepository.save(newReview);
    }

    @Override
    public List<Review> getAllReviewsByBusinessId(Long businessId) {
        return reviewRepository.findAllByBusinessId(businessId);
    }

    @Override
    public void deleteReviewByBusinessId(Long businessId) {
        reviewRepository.deleteByBusinessId(businessId);
    }
}
