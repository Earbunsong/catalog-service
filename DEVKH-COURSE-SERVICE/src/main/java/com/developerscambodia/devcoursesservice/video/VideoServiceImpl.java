package com.developerscambodia.devcoursesservice.video;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    @Override
    public void createNewVideo(Video video) {
        video.setCreateAt(LocalDateTime.now());
        video.setUpdateAt(LocalDateTime.now());
        video.setUuid(UUID.randomUUID().toString());

        // Use the repository to save the video
        videoRepository.save(video);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Optional<Video> findByUuid(String uuid) {
        return videoRepository.findByUuid(uuid);
    }

    @Override
    public List<Video> getVideosBySectionUuid(String sectionUuid) {
        return videoRepository.findBySectionUuid(sectionUuid);
    }


}
