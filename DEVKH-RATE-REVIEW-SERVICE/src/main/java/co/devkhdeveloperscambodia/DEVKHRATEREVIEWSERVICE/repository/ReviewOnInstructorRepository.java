package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.repository;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnInstructor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReviewOnInstructorRepository extends ReactiveMongoRepository<ReviewOnInstructor,String> {
    Flux<ReviewOnInstructor> findByInstructorId(Long instructorId);
}
