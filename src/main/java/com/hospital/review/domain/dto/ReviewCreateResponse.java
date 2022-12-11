package com.hospital.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateResponse {
    private Long id;
    private String hospitalName;
    private String roadNameAddress;
}
