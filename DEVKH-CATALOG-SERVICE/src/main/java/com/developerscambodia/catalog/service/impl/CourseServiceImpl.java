package com.developerscambodia.catalog.service.impl;

import com.developerscambodia.catalog.dto.CourseCardDto;
import com.developerscambodia.catalog.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Override
    public List<CourseCardDto> findFreeCourseList() {
        return null;
    }

}
