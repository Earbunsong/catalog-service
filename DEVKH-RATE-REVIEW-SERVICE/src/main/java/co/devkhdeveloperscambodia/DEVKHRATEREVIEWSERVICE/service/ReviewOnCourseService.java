package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.service;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnCourse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewOnCourseService {

    Mono<ReviewOnCourse> create(ReviewOnCourse review);

    Flux<ReviewOnCourse> findByCourseId(Long courseId);

    Flux<ReviewOnCourse> findAll();

    Mono<ReviewOnCourse> findById(String id);

    Mono<ReviewOnCourse> updateCourse(String id,ReviewOnCourse reviewOnCourse);

    Mono<ReviewOnCourse> deleteCourse(String id);

}
