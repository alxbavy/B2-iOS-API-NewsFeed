package com.poly.feedback.api;

import com.poly.feedback.dto.request.FeedBackRequest;
import com.poly.feedback.dto.response.FeedBackResponse;
import com.poly.feedback.entity.FeedBack;
import com.poly.feedback.service.FeedBackService;
import com.poly.feedback.utils.UserUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/feedback"})
@CrossOrigin
public class FeedBackApi {

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private UserUtils userUtils;

    @GetMapping({"/find-by-product"})
    public ResponseEntity<?> findByProduct(@RequestParam("product-id") Long productId, Pageable pageable, HttpServletRequest request) {
        return new ResponseEntity<>(feedBackService.findByProductId(productId,pageable), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody FeedBackRequest feedBackRequest, HttpServletRequest request){
        FeedBackResponse result = feedBackService.save(feedBackRequest, request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FeedBackRequest feedBackRequest,@PathVariable Long id, HttpServletRequest request){
        FeedBackResponse result = feedBackService.update(feedBackRequest, id, request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, HttpServletRequest request){
        feedBackService.delete(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}