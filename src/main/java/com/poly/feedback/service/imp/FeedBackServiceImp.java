package com.poly.feedback.service.imp;

import com.poly.feedback.dto.request.FeedBackRequest;
import com.poly.feedback.dto.response.FeedBackResponse;
import com.poly.feedback.entity.FeedBack;
import com.poly.feedback.entity.User;
import com.poly.feedback.exception.MessageException;
import com.poly.feedback.mapper.FeedBackMapper;
import com.poly.feedback.repository.FeedBackRepository;
import com.poly.feedback.service.AuthenticationService;
import com.poly.feedback.service.FeedBackService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.poly.feedback.utils.CommonPage;
import com.poly.feedback.utils.UserUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class FeedBackServiceImp implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Autowired
    private CommonPage commonPage;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Page<FeedBackResponse> findByProductId(Long productId, Pageable pageable) {
        Page<FeedBack> page = feedBackRepository.findParentFeedBack(productId, pageable);
        List<FeedBackResponse> list = feedBackMapper.listFeedBackToListResponse(page.getContent());
        Page<FeedBackResponse> result = commonPage.restPage(page,list);
        return result;
    }

    @Override
    public FeedBackResponse save(FeedBackRequest feedBackRequest, HttpServletRequest httpServletRequest) {
        String token = userUtils.getToken(httpServletRequest);
        if(token == null){
            throw new MessageException("token not found");
        }
        User user = null;
        try {
            user = authenticationService.getUserByToken(httpServletRequest);
        }catch (Exception e){
            throw new MessageException("token not found");
        }
        FeedBack feedBack = feedBackMapper.requestToFeedBack(feedBackRequest);
        if(feedBackRequest.getFeedBackParentId() != null){
            Optional<FeedBack> f = feedBackRepository.findById(feedBackRequest.getFeedBackParentId());
            if(f.isEmpty()){
                throw new MessageException("Parent feedback not found");
            }
            else{
                feedBack.setFeedback(f.get());
            }
        }
        feedBack.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        feedBack.setUserId(user.getId());
        feedBack.setEmail(user.getEmail());
        FeedBack result = feedBackRepository.save(feedBack);
        return feedBackMapper.feedBackToResponse(result);
    }

    @Override
    public FeedBackResponse update(FeedBackRequest feedBackRequest, Long id, HttpServletRequest httpServletRequest) {
        if(id == null){
            throw new MessageException("Id can't null");
        }
        String token = userUtils.getToken(httpServletRequest);
        if(token == null){
            throw new MessageException("token not found");
        }
        User user = null;
        try {
            user = authenticationService.getUserByToken(httpServletRequest);
        }catch (Exception e){
            throw new MessageException("token not found");
        }
        Optional<FeedBack> exist = feedBackRepository.findById(id);
        if(exist.isEmpty()){
            throw new MessageException("Feedback not found");
        }
        if(exist.get().getUserId() != user.getId()){
            throw new MessageException("Access denied");
        }
        exist.get().setContent(feedBackRequest.getContent());
        exist.get().setRating(feedBackRequest.getRating());
        FeedBack result = feedBackRepository.save(exist.get());
        return feedBackMapper.feedBackToResponse(result);
    }


    @Override
    public void delete(Long id, HttpServletRequest httpServletRequest) {
        if(id == null){
            throw new MessageException("Id can't null");
        }
        String token = userUtils.getToken(httpServletRequest);
        if(token == null){
            throw new MessageException("token not found");
        }
        User user = null;
        try {
            user = authenticationService.getUserByToken(httpServletRequest);
        }catch (Exception e){
            throw new MessageException("token not found");
        }
        Optional<FeedBack> exist = feedBackRepository.findById(id);
        if(exist.isEmpty()){
            throw new MessageException("Feedback not found");
        }
        if(exist.get().getUserId() != user.getId()){
            throw new MessageException("Access denied");
        }
        feedBackRepository.delete(exist.get());
    }
}
