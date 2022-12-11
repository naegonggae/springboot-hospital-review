package com.hospital.review.service;

import com.hospital.review.domain.Hospital;
import com.hospital.review.domain.Review;
import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import com.hospital.review.repository.HospitalRepository;
import com.hospital.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewCreateResponse createReview(ReviewCreateRequest dto) {
        // Hospital 불러오기
        Optional<Hospital> optionalHospital = hospitalRepository.findById(dto.getHospitalId());

        // ReviewEntity 만들기
        Review review = Review.builder()
                .id(null)
                .title(dto.getTitle())
                .content(dto.getContent())
                .patientName(dto.getUserName())
                .hospital(optionalHospital.get())
                .build();

        // 저장
        Review savedReview = reviewRepository.save(review);

        return ReviewCreateResponse.builder()
                .userName(savedReview.getPatientName())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .message("리뷰 등록이 성공했습니다.")
                .build();
    }

    public Review getReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id가 없습니다."));

        Optional<Review> optionalReview = reviewRepository.findById(id);
        optionalReview.isEmpty();
        optionalReview.orElseThrow();
        // Optional의 사용
        // 1. Optional왜 쓰는지? null을 안쓸려고 쓴다.
        // 2. Optional왜 쓰는지? DB조회 할 때 .findById()를 쓸 때 안나올 수 있다.
        // 3. Optional을 썼을때 .orElseThrow(), .orElse(), ifPresent() 등 편의기능을 써서 코드를 짧게 쓸 수 있다.

        return review;
    }
}
