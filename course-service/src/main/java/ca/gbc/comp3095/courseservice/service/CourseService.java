package ca.gbc.comp3095.courseservice.service;

import ca.gbc.comp3095.courseservice.dto.CourseRequestDTO;
import ca.gbc.comp3095.courseservice.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO getCourseById(Long id);

    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);

    // -- New methods for PUT / DELETE --- //
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);

    void deleteCourse(Long id);

}
