package com.developerscambodia.catalog.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CourseDto(
        String uuid,
        String title,

        String description,
        BigDecimal price,
        Integer discount,
        Boolean isPaid,
        String thumbnail,
        String categoryUuid,
        LocalDateTime createdAt
//        RatingResponse rating
) {
}
