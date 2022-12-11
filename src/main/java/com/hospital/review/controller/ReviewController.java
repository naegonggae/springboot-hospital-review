package com.hospital.review.controller;

import com.hospital.review.domain.Review;
import com.hospital.review.domain.dto.ReviewReadResponse;
import com.hospital.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@Slf4j
@RequiredArgsConstructor // 필요한 argument 넣어줌
public class ReviewController {

    private final ReviewService reviewService;
    // 1개 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id) {
        Review review = reviewService.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable Long hospitalId) {
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(hospitalId));
    }
}
