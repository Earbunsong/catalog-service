package com.developerscambodia.catalog.service;

import com.developerscambodia.catalog.dto.CourseCardDto;

import java.util.List;

public interface CourseService {

    List<CourseCardDto> findFreeCourseList();

}
