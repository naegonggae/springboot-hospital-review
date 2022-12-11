package com.hospital.review.service;

import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    public ReviewCreateResponse createReview(ReviewCreateRequest dto) {
        return new ReviewCreateResponse();
    }
}
