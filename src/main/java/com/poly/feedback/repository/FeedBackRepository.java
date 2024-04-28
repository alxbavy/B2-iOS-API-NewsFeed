package com.poly.feedback.repository;

import java.util.List;

import com.poly.feedback.entity.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    @Query("select f from FeedBack f where f.feedback.id is null and f.productId = ?1")
    Page<FeedBack> findParentFeedBack(Long productId, Pageable pageable);
}