package com.hospital.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateResponse {
    private Long id;
    private String userName;
    private String title;
    private String content;
    private String message;
}
