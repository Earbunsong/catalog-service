package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.controller;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnInstructor;
import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.service.ReviewOnInstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews-on-instructor")
public class ReviewOnInstructorController {
    private final ReviewOnInstructorService reviewOnInstructorService;

    @PostMapping
    public Mono<ReviewOnInstructor> create(@RequestBody ReviewOnInstructor reviewOnInstructor){
        return reviewOnInstructorService.createReviewOnInstructor(reviewOnInstructor);
    }

    @GetMapping("/{instructorId}")
    public Flux<ReviewOnInstructor> findByInstructorId(@PathVariable Long instructorId){
        return reviewOnInstructorService.findByInstructorId(instructorId);
    }
    @GetMapping
    public Flux<ReviewOnInstructor> findAll(){
        return reviewOnInstructorService.findAll();
    }
    @GetMapping("/byId/{id}")
    public Mono<ReviewOnInstructor> findById(@PathVariable String id){
        return reviewOnInstructorService.findById(id);
    }
    @PutMapping("/{id}")
    public Mono<ReviewOnInstructor> update(@PathVariable String id,@RequestBody ReviewOnInstructor reviewOnInstructor){
        return reviewOnInstructorService.updateById(id,reviewOnInstructor);
    }
    @DeleteMapping("/{id}")
    public Mono<ReviewOnInstructor> delete(@PathVariable String id){
        return reviewOnInstructorService.deleteById(id);
    }
}
