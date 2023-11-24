package com.developerscambodia.devcoursesservice.category;

import com.developerscambodia.devcoursesservice.category.web.CategoryDto;
import com.developerscambodia.devcoursesservice.category.web.CreateCategoryDto;
import com.developerscambodia.devcoursesservice.category.web.UpdateCategoryDto;
import com.developerscambodia.devcoursesservice.course.Course;
import com.developerscambodia.devcoursesservice.course.CourseMapper;
import com.developerscambodia.devcoursesservice.course.CourseRepository;
import com.developerscambodia.devcoursesservice.course.web.CourseDto;
import com.developerscambodia.devcoursesservice.section.Section;
import com.developerscambodia.devcoursesservice.section.SectionRepository;
import com.developerscambodia.devcoursesservice.video.Video;
import com.developerscambodia.devcoursesservice.video.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategorySeviceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final SectionRepository sectionRepository;
    private final VideoRepository videoRepository;
//    private final CourseMapper courseMapper;
    @Override
    public CreateCategoryDto createNewCategory(CreateCategoryDto createCategoryDto) {
        Category category = categoryMapper.createCategoryDtoToCategory(createCategoryDto);

        // Generate a UUID for the new category
        String uuid = UUID.randomUUID().toString();
        category.setUuid(uuid);

        // Save the category to the database
        categoryRepository.save(category);

        // Return the CategoryDto representation of the saved category
        return categoryMapper.createCategoryToCategoryDto(category);
    }

    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        categories.forEach(category -> {
            List<Course> courses = courseRepository.findByCategoryUuid(category.getUuid());

            // Fetch and set courses for the category
            category.setCourses(courses);

            // Fetch and set sections for each course
            courses.forEach(course -> {
                List<Section> sections = sectionRepository.findByCourseUuid(course.getUuid());
                course.setSections(sections);

                // Fetch and set videos for each section
                sections.forEach(section -> {
                    List<Video> videos = videoRepository.findBySectionUuid(section.getUuid());
                    section.setVideos(videos);
                });
            });
        });

        return categoryMapper.categoriesToCategoryDtos(categories);
    }

    @Override
    public CategoryDto findCategoryByUuid(String uuid) {
        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Course not found with UUID: " + uuid));

        return categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public void removeCategoryByUuid(String uuid) {
        // Check if the category exists
        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Category with UUID: " + uuid + " not found"));

        // Delete the category from the database
        categoryRepository.delete(category);
    }


    @Override
    public UpdateCategoryDto editCategoryByUuid(String uuid, UpdateCategoryDto updatedCategoryDto) {
        Category existingCategory = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found with UUID: " + uuid));

        existingCategory.setName(updatedCategoryDto.name());

        Category updatedCategory = categoryRepository.save(existingCategory);

        // Convert the updated Category object to UpdateCategoryDto using the mapper
        UpdateCategoryDto updatedCategoryDtoResponse = categoryMapper.categoryToUpdateCategoryDto(updatedCategory);

        return updatedCategoryDtoResponse;
    }

    @Override
    public Optional<Category> findCategoryByUuidWithCourse(String categoryUuid) {
        Optional<Category> optionalCategory = categoryRepository.findByUuid(categoryUuid);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            List<Course> courses = courseRepository.findByCategoryUuid(categoryUuid);

            // Fetch and set courses for the category
            category.setCourses(courses);

            // Fetch and set sections for each course
            for (Course course : courses) {
                List<Section> sections = sectionRepository.findByCourseUuid(course.getUuid());
                course.setSections(sections);
                // Fetch and set videos for each section
                for (Section section : sections) {
                    List<Video> videos = videoRepository.findBySectionUuid(section.getUuid());
                    section.setVideos(videos);
                }
            }

            return Optional.of(category);
        } else {
            return Optional.empty();
        }

    }




}
