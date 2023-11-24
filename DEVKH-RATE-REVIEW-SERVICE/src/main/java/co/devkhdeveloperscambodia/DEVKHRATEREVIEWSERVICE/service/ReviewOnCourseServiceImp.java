package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.service;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnCourse;
import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.repository.ReviewOnCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReviewOnCourseServiceImp implements ReviewOnCourseService {
    private final ReviewOnCourseRepository reviewRepository;

    @Override
    public Mono<ReviewOnCourse> create(ReviewOnCourse review) {
        return reviewRepository.save(review);
    }

    @Override
    public Flux<ReviewOnCourse> findByCourseId(Long courseId) {
        return reviewRepository.findByCourseId(courseId);
    }

    @Override
    public Flux<ReviewOnCourse> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Mono<ReviewOnCourse> findById(String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Mono<ReviewOnCourse> updateCourse(String id, ReviewOnCourse reviewOnCourse) {
        return reviewRepository.findById(id).flatMap(upCourse->{
            upCourse.setReviews(reviewOnCourse.getReviews());
            upCourse.setCourseRating(reviewOnCourse.getCourseRating());
            upCourse.setStudents(reviewOnCourse.getStudents());
            return reviewRepository.save(upCourse);
        });
    }

    @Override
    public Mono<ReviewOnCourse> deleteCourse(String id) {
        return reviewRepository.findById(id).flatMap(existingC->
                reviewRepository.delete(existingC).then(Mono.just(existingC)));
    }

}
