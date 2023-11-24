package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.service;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnInstructor;
import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.repository.ReviewOnInstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReviewOnInstructorServiceImp implements ReviewOnInstructorService{
    private final ReviewOnInstructorRepository repository;

    @Override
    public Mono<ReviewOnInstructor> createReviewOnInstructor(ReviewOnInstructor reviewOnInstructor) {
        return repository.save(reviewOnInstructor);
    }

    @Override
    public Flux<ReviewOnInstructor> findByInstructorId(Long instructorId) {
        return repository.findByInstructorId(instructorId);
    }

    @Override
    public Flux<ReviewOnInstructor> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<ReviewOnInstructor> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<ReviewOnInstructor> updateById(String id, ReviewOnInstructor reviewOnInstructor) {
        return repository.findById(id).flatMap(upI->{
            upI.setReviews(reviewOnInstructor.getReviews());
            upI.setInstructorRating(reviewOnInstructor.getInstructorRating());
            upI.setCourses(reviewOnInstructor.getCourses());
            upI.setStudents(reviewOnInstructor.getStudents());
            return repository.save(upI);
        });
    }

    @Override
    public Mono<ReviewOnInstructor> deleteById(String id) {
        return repository.findById(id).flatMap(existingI->
                repository.delete(existingI).then(Mono.just(existingI)));
    }

}
