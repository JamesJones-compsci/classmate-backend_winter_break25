package ca.gbc.comp3095.gradeservice.service;

import ca.gbc.comp3095.gradeservice.dto.GradeRequestDTO;
import ca.gbc.comp3095.gradeservice.dto.GradeResponseDTO;
import ca.gbc.comp3095.gradeservice.exception.GradeNotFoundException;
import ca.gbc.comp3095.gradeservice.model.Grade;
import ca.gbc.comp3095.gradeservice.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository){

        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<GradeResponseDTO> getAllGrades(){
        return gradeRepository.findAll()
                .stream()
                .map(grade -> new GradeResponseDTO(
                        grade.getId(),
                        grade.getCourseCode(),
                        grade.getCourseName(),
                        grade.getType(),
                        grade.getGrade(),
                        grade.getWeight(),
                        grade.getFeedback()
                ))
                .toList();
    }

    @Override
    public GradeResponseDTO getGradeById(Long id){
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new GradeNotFoundException(id));

        return new GradeResponseDTO(
                grade.getId(),
                grade.getCourseCode(),
                grade.getCourseName(),
                grade.getType(),
                grade.getGrade(),
                grade.getWeight(),
                grade.getFeedback()
        );
    }

    @Override
    public GradeResponseDTO createGrade(GradeRequestDTO dto){
        Grade grade = new Grade(
                dto.getCourseCode(),
                dto.getCourseName(),
                dto.getType(),
                dto.getGrade(),
                dto.getWeight(),
                dto.getFeedback()
        );

        Grade saved = gradeRepository.save(grade);

        return new GradeResponseDTO(
                saved.getId(),
                saved.getCourseCode(),
                saved.getCourseName(),
                saved.getType(),
                saved.getGrade(),
                saved.getWeight(),
                saved.getFeedback()
        );
    }

    // -- New method: updateGrade() -- //
    @Override
    public GradeResponseDTO updateGrade(Long id, GradeRequestDTO dto){
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new GradeNotFoundException(id));

        grade.setCourseCode(dto.getCourseCode());
        grade.setCourseName(dto.getCourseName());
        grade.setType(dto.getType());
        grade.setGrade(dto.getGrade());
        grade.setWeight(dto.getWeight());
        grade.setFeedback(dto.getFeedback());

        Grade saved = gradeRepository.save(grade);

        return new GradeResponseDTO(
                saved.getId(),
                saved.getCourseCode(),
                saved.getCourseName(),
                saved.getType(),
                saved.getGrade(),
                saved.getWeight(),
                saved.getFeedback()
        );
    }

    // -- New method: deleteGrade() -- //
    @Override
    public void deleteGrade(Long id){
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new GradeNotFoundException(id));
        gradeRepository.delete(grade);
    }
}
