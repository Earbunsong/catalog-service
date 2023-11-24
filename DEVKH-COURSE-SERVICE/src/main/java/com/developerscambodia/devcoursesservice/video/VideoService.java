package com.developerscambodia.devcoursesservice.video;

import com.developerscambodia.devcoursesservice.course.web.CreateCourseDto;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    void createNewVideo(Video video);
    List<Video> getAllVideos();

    Optional<Video> findByUuid(String uuid);

    List<Video> getVideosBySectionUuid(String sectionUuid);

    //  Video findByUuid(String uuid);
}
