package com.hospital.review.repository;

import com.hospital.review.domain.Hospital;
import com.hospital.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHospital(Hospital hospital);
}
