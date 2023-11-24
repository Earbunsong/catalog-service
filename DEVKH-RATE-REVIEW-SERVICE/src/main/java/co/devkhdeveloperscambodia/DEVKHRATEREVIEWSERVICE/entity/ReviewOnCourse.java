package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews-on-course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewOnCourse {
    @Id
    private String id;
    private Long courseId;
    private Long reviews;
    private String courseRating;
    private Long students;

}
