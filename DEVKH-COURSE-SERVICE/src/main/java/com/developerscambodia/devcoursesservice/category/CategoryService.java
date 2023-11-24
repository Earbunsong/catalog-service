package com.developerscambodia.devcoursesservice.category;

import com.developerscambodia.devcoursesservice.category.web.CategoryDto;
import com.developerscambodia.devcoursesservice.category.web.CreateCategoryDto;
import com.developerscambodia.devcoursesservice.category.web.UpdateCategoryDto;
import com.developerscambodia.devcoursesservice.course.Course;
import com.developerscambodia.devcoursesservice.course.web.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
//    CategoryDto createNewCategory(CategoryDto categoryDto);

    CreateCategoryDto createNewCategory(CreateCategoryDto createCategoryDto);

    List<CategoryDto> findAllCategories();


    CategoryDto findCategoryByUuid(String uuid);

    void removeCategoryByUuid(String uuid);

    UpdateCategoryDto editCategoryByUuid(String uuid, UpdateCategoryDto updatedCategoryDto);


    Optional<Category> findCategoryByUuidWithCourse(String categoryUuid);



}
