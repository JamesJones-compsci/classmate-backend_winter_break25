package ca.gbc.comp3095.gradeservice.service;

import ca.gbc.comp3095.gradeservice.dto.GradeRequestDTO;
import ca.gbc.comp3095.gradeservice.dto.GradeResponseDTO;

import java.util.List;

public interface GradeService {

    List<GradeResponseDTO> getAllGrades();

    GradeResponseDTO getGradeById(Long id);

    GradeResponseDTO createGrade(GradeRequestDTO gradeRequestDTO);

    GradeResponseDTO updateGrade(Long id, GradeRequestDTO gradeRequestDTO);

    void deleteGrade(Long id);
}
