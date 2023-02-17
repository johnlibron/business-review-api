package com.crescendo.controller.rest;

import com.crescendo.model.Business;
import com.crescendo.service.IBusinessService;
import com.crescendo.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/businesses")
@RestController
public class BusinessController {

    @Autowired
    private IBusinessService iBusinessService;

    @Autowired
    private IReviewService iReviewService;

    @PostMapping()
    public ResponseEntity<String> createBusiness(@RequestBody Business newBusiness) {
        try {
            iBusinessService.createBusiness(newBusiness);
            return new ResponseEntity<>("Successfully created business '" + newBusiness.getBusinessName() + "'", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Business>> getAllBusinesses() {
        return new ResponseEntity<>(iBusinessService.getAllBusinesses(), HttpStatus.OK);
    }

    @GetMapping("{business_id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable("business_id") Long id) {
        return new ResponseEntity<>(iBusinessService.getBusinessById(id), HttpStatus.OK);
    }

    @PutMapping("{business_id}")
    public ResponseEntity<Business> updateBusinessById(@PathVariable("business_id") Long id, @RequestBody Business updateBusiness) {
        updateBusiness.setId(id);
        return new ResponseEntity<>(iBusinessService.updateBusiness(updateBusiness), HttpStatus.OK);
    }

    @DeleteMapping("{business_id}")
    public ResponseEntity<String> deleteBusinessById(@PathVariable("business_id") Long id) {
        try {
            iBusinessService.deleteBusinessById(id);
            iReviewService.deleteReviewByBusinessId(id);
            return new ResponseEntity<>("Successfully deleted business '" + id + "'", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
