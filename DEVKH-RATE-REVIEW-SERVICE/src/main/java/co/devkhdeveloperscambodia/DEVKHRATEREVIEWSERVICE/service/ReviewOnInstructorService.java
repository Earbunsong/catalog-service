package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.service;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnInstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewOnInstructorService {

    Mono<ReviewOnInstructor> createReviewOnInstructor(ReviewOnInstructor reviewOnInstructor);

    Flux<ReviewOnInstructor> findByInstructorId(Long instructorId);

    Flux<ReviewOnInstructor> findAll();

    Mono<ReviewOnInstructor> findById(String id);

    Mono<ReviewOnInstructor> updateById(String id,ReviewOnInstructor reviewOnInstructor);

    Mono<ReviewOnInstructor> deleteById(String id);

}
