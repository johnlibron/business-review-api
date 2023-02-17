package com.crescendo.service;

import com.crescendo.model.Business;
import com.crescendo.repository.BusinessRepository;
import com.crescendo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public void createBusiness(Business newBusiness) throws Exception {
        if (Objects.nonNull(businessRepository.findByBusinessName(newBusiness.getBusinessName()))) {
            throw new Exception("Existing business name found: " + newBusiness.getBusinessName());
        }
        businessRepository.save(newBusiness);
    }

    @Override
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id).orElseThrow();
    }

    @Override
    public Business updateBusiness(Business updateBusiness) {
        businessRepository.findById(updateBusiness.getId()).orElseThrow();
        return businessRepository.save(updateBusiness);
    }

    @Override
    public void deleteBusinessById(Long id) {
        businessRepository.findById(id).orElseThrow();
        businessRepository.deleteById(id);
    }
}
