package com.crescendo.controller.rest;

import com.crescendo.model.Business;
import com.crescendo.model.Review;
import com.crescendo.service.IBusinessService;
import com.crescendo.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/businesses")
@RestController
public class ReviewController {

    @Autowired
    private IBusinessService iBusinessService;

    @Autowired
    private IReviewService iReviewService;

    @PostMapping("{business_id}/reviews")
    public ResponseEntity<String> createBusiness(@PathVariable("business_id") Long businessId,
                                                 @RequestBody Review newReview) {
        iBusinessService.getBusinessById(businessId);
        newReview.setBusinessId(businessId);
        iReviewService.createBusinessReview(newReview);
        return new ResponseEntity<>("Successfully created business '" + businessId + "' review", HttpStatus.CREATED);
    }

    @GetMapping("{business_id}/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByBusinessId(@PathVariable("business_id") Long businessId) {
        return new ResponseEntity<>(iReviewService.getAllReviewsByBusinessId(businessId), HttpStatus.OK);
    }
}
