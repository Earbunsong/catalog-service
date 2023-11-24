package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.repository;

import co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity.ReviewOnCourse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReviewOnCourseRepository extends ReactiveMongoRepository<ReviewOnCourse,String> {
    Flux<ReviewOnCourse> findByCourseId(Long courseId);
}
