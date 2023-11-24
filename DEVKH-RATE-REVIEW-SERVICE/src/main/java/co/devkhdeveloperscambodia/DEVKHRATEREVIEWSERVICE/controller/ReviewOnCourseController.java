package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.controller;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnCourse;
import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.service.ReviewOnCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews-on-course")
public class ReviewOnCourseController {
    private final ReviewOnCourseService reviewService;

    @PostMapping
    public Mono<ReviewOnCourse> create(@RequestBody ReviewOnCourse review){
        return reviewService.create(review);
    }
    @GetMapping("/{courseId}")
    public Flux<ReviewOnCourse> findByCourseId(@PathVariable Long courseId){
        return reviewService.findByCourseId(courseId);
    }
    @GetMapping
    public Flux<ReviewOnCourse> findAll(){
        return reviewService.findAll();
    }
    @GetMapping("/byId/{id}")
    public Mono<ReviewOnCourse> findById(@PathVariable String id){
        return reviewService.findById(id);
    }
    @PutMapping("/{id}")
    public Mono<ReviewOnCourse> updateCourse(@PathVariable String id,@RequestBody ReviewOnCourse reviewOnCourse){
        return reviewService.updateCourse(id,reviewOnCourse);
    }
    @DeleteMapping("/{id}")
    public Mono<ReviewOnCourse> deleteCourse(@PathVariable String id){
        return reviewService.deleteCourse(id);
    }
}
