package com.poly.feedback.service;

import com.poly.feedback.entity.FeedBack;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface FeedBackService {
    List<FeedBack> findAll();
}