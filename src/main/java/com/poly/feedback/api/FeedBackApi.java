package com.poly.feedback.api;

import com.poly.feedback.entity.FeedBack;
import com.poly.feedback.service.FeedBackService;
import com.poly.feedback.utils.UserUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/feedback"})
@CrossOrigin
public class FeedBackApi {
    @Autowired
    private FeedBackService feedBackService;
    @Autowired
    private UserUtils userUtils;

    @GetMapping({"/public/all"})
    public List<FeedBack> all(HttpServletRequest request) {
        this.userUtils.getUserWithAuthority(request);
        return this.feedBackService.findAll();
    }
}