package com.developerscambodia.catalog.client;

import com.developerscambodia.catalog.dto.ApiDto;
import com.developerscambodia.catalog.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "COURSE-SERVICE", url = "http://localhost:8086/api/v1/courses")
public interface CourseClient {
    @GetMapping
    ApiDto<Page<CourseDto>> getListOfCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
}
