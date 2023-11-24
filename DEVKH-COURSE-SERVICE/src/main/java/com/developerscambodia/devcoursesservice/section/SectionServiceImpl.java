package com.developerscambodia.devcoursesservice.section;

import com.developerscambodia.devcoursesservice.course.CourseRepository;
import com.developerscambodia.devcoursesservice.section.web.CreateSectionDto;
import com.developerscambodia.devcoursesservice.section.web.SectionDto;
import com.developerscambodia.devcoursesservice.section.web.UpdateSectionDto;
import com.developerscambodia.devcoursesservice.video.Video;
import com.developerscambodia.devcoursesservice.video.VideoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;
    private final MongoTemplate mongoTemplate;
    private final CourseRepository courseRepository;
    private final VideoRepository videoRepository;
    @Override
    public CreateSectionDto createSection(CreateSectionDto createSectionDto) {
        Section section = sectionMapper.createSectionDtoToSection(createSectionDto);
        section.setUuid(UUID.randomUUID().toString());
        sectionRepository.save(section);
        return sectionMapper.sectionToCreateSection(section);
    }


    @Override
    public Optional<Section> findSectionByUuid(String sectionUuid) {
        Optional<Section> section = sectionRepository.findByUuid(sectionUuid);

        // Assuming you have a method in your Section entity to get videos
        section.ifPresent(sec -> sec.setVideos(videoRepository.findBySectionUuid(sectionUuid)));

        return section;

    }



//    @Override
//    public Optional<SectionDto> findSectionByUuid(String sectionUuid) {
//        Optional<Section> section = sectionRepository.findByUuid(sectionUuid);
//
//        Optional<SectionDto> sectionDto = section.map(sectionMapper::sectionToSectionDto);
//
//        return sectionDto;
//    }



    @Override
    public UpdateSectionDto editSectionByUuid(String uuid, UpdateSectionDto updatedSectionDto) {
        //Section existingSection = sectionRepository.findByUuid(sectionUuid);


        Section existingSection = sectionRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Section not found with UUID: " + uuid));

        // Update the existing course with the new data from updatedCourseDto
        existingSection.setName(updatedSectionDto.name());
       // existingCourse.setDescription(updatedCourseDto.description());

        // Update other properties as needed...

        // Save the updated Section to the repository
        Section updatedSection = sectionRepository.save(existingSection);

        // Convert the updated Section object to CourseDto using the mapper
        UpdateSectionDto updateSectionDto = sectionMapper.sectionToUpdateSectionDto(updatedSection);

        return updatedSectionDto;
    }

    @Override
    public void removeSectionByUuid(String uuid) {
        Section existingSection = sectionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Section not found with UUID: " + uuid));

        sectionRepository.delete(existingSection);
    }


    @Override
    public Page<SectionDto> findListSections(String courseUuid, int page, int size) {
        // Create a PageRequest object to define the pagination parameters
        PageRequest pageable = PageRequest.of(page, size);

        // Declare a Page object to store the result of the database query
        Page<Section> sectionPage;

        // Check if a course UUID is provided
        if (courseUuid != null && !courseUuid.isEmpty()) {
            // If a course UUID is provided, query the database for sections specific to that course using the repository
            sectionPage = sectionRepository.findByCourseUuid(courseUuid, pageable);
        } else {
            // If no course UUID is provided, retrieve all sections from the database using the repository
            sectionPage = sectionRepository.findAll(pageable);
        }

        // Convert the Page<Section> to Page<SectionDto> using the map function provided by the SectionMapper
        Page<SectionDto> sectionDtoPage = sectionPage.map(sectionMapper::sectionToSectionDto);

        // Return the paginated list of SectionDto objects
        return sectionDtoPage;
    }

//
//    @Override
//    public List<Section> getSectionsByCourseUuid(String courseUuid) {
//        return sectionRepository.findByCourseUuid(courseUuid);
//    }


}