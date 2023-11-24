package com.developerscambodia.catalog.dto;

public record CourseCardDto(
        String uuid,
        String title,
        String thumbnail,
        String instructor,
        String ratingStar,
        Long reviewCount,
        Boolean isPaid,
        Double price
) {
}
