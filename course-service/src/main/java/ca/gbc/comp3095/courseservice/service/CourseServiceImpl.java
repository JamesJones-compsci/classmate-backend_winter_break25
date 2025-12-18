package ca.gbc.comp3095.courseservice.service;

/*
* This ensures that the controller stays thin
* Mapping happens in service
* Exceptions are domain-specific
*/


import ca.gbc.comp3095.courseservice.dto.CourseRequestDTO;
import ca.gbc.comp3095.courseservice.dto.CourseResponseDTO;
import ca.gbc.comp3095.courseservice.exception.CourseNotFoundException;
import ca.gbc.comp3095.courseservice.model.Course;
import ca.gbc.comp3095.courseservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){

        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses(){
        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseResponseDTO(
                        course.getId(),
                        course.getCode(),
                        course.getTitle(),
                        course.getDescription()
                ))
                .toList();
    }

    @Override
    public CourseResponseDTO getCourseById(Long id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));

        return new CourseResponseDTO(
                course.getId(),
                course.getCode(),
                course.getTitle(),
                course.getDescription()
        );
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto){
        Course course = new Course(
                dto.getCode(),
                dto.getTitle(),
                dto.getDescription()
        );

        Course saved = courseRepository.save(course);

        return new CourseResponseDTO(
                saved.getId(),
                saved.getCode(),
                saved.getTitle(),
                saved.getDescription()
        );
    }

    // -- New method: updateCourse() -- //
    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));

        course.setCode(dto.getCode());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());

        Course saved = courseRepository.save(course);

        return new CourseResponseDTO(
                saved.getId(),
                saved.getCode(),
                saved.getTitle(),
                saved.getDescription()
        );
    }

    // -- New method: deleteCourse() -- //
    @Override
    public void deleteCourse(Long id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        courseRepository.delete(course);
    }
}
