package com.developerscambodia.devcoursesservice.video.web;

import com.developerscambodia.devcoursesservice.video.Video;
import com.developerscambodia.devcoursesservice.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<Void> createNewVideo(@RequestBody Video video) {
        videoService.createNewVideo(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Video> getVideoByUuid(@PathVariable String uuid) {
        Optional<Video> optionalVideo = videoService.findByUuid(uuid);
        return optionalVideo.map(video -> new ResponseEntity<>(video, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/section/{sectionUuid}")
    public List<Video> getVideosBySectionUuid(@PathVariable String sectionUuid) {
        return videoService.getVideosBySectionUuid(sectionUuid);
    }
}
