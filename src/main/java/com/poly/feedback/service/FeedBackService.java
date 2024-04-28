package com.poly.feedback.service;

import com.poly.feedback.dto.request.FeedBackRequest;
import com.poly.feedback.dto.response.FeedBackResponse;
import com.poly.feedback.entity.FeedBack;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FeedBackService {

    Page<FeedBackResponse> findByProductId(Long productId,Pageable pageable);

    FeedBackResponse save(FeedBackRequest feedBackRequest, HttpServletRequest httpServletRequest);

    FeedBackResponse update(FeedBackRequest feedBackRequest, Long id, HttpServletRequest httpServletRequest);

    void delete(Long id, HttpServletRequest httpServletRequest);
}