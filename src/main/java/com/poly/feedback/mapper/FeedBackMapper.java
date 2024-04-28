package com.poly.feedback.mapper;

import com.poly.feedback.dto.request.FeedBackRequest;
import com.poly.feedback.dto.response.FeedBackResponse;
import com.poly.feedback.entity.FeedBack;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeedBackMapper {


    @Autowired
    private ModelMapper mapper;

    public FeedBackResponse feedBackToResponse(FeedBack feedBack){
        FeedBackResponse response = mapper.map(feedBack, FeedBackResponse.class);
        return response;
    }

    public FeedBack requestToFeedBack(FeedBackRequest request){
        FeedBack feedBack = mapper.map(request, FeedBack.class);
        return feedBack;
    }

    public List<FeedBackResponse> listFeedBackToListResponse(List<FeedBack> list){
        List<FeedBackResponse> responses = list.stream().map(post -> mapper.map(post, FeedBackResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
}
