package com.developerscambodia.devcoursesservice.video;

import com.developerscambodia.devcoursesservice.section.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends MongoRepository<Video, String> {
    Optional<Video> findByUuid(String uuid);
    List<Video> findBySectionUuid(String sectionUuid);
}
