package com.crescendo.service;

import com.crescendo.model.Business;

import java.util.List;

public interface IBusinessService {

    void createBusiness(Business newBusiness) throws Exception;

    List<Business> getAllBusinesses();

    Business getBusinessById(Long id);

    Business updateBusiness(Business updateBusiness);

    void deleteBusinessById(Long id);
}
