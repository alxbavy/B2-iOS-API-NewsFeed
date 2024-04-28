package com.poly.feedback.service.imp;

import com.poly.feedback.entity.FeedBack;
import com.poly.feedback.repository.FeedBackRepository;
import com.poly.feedback.service.FeedBackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedBackServiceImp implements FeedBackService {
    @Autowired
    private FeedBackRepository feedBackRepository;

    public List<FeedBack> findAll() {
        List<FeedBack> list = this.feedBackRepository.findParentFeedBack();
        System.out.println(list.size());
        return list;
    }
}
