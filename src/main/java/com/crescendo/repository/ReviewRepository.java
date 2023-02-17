package com.crescendo.repository;

import com.crescendo.model.Business;
import com.crescendo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    void deleteByBusinessId(Long businessId);

    List<Review> findAllByBusinessId(Long businessId);
}
