package com.crescendo.service;

import com.crescendo.model.Business;
import com.crescendo.model.Review;

import java.util.List;

public interface IReviewService {

    void createBusinessReview(Review newReview);

    List<Review> getAllReviewsByBusinessId(Long businessId);

    void deleteReviewByBusinessId(Long businessId);
}
