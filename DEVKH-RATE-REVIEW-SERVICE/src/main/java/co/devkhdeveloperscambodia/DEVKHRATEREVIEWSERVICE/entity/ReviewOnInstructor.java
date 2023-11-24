package co.devkhdeveloperscambodia.DEVKHRATEREVIEWSERVICE.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews-on-instructor")
@Builder
public class ReviewOnInstructor {
    @Id
    private String id;
    private Long instructorId;
    private Long reviews;
    private String instructorRating;
    private Long students;
    private Long courses;

}
