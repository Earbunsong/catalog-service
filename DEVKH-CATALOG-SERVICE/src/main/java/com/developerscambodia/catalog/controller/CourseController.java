package com.developerscambodia.catalog.controller;

import com.developerscambodia.catalog.dto.CourseCardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @GetMapping("/courses/free")
    List<CourseCardDto> findFreeCourseList() {
        return null;
    }


}
