package ca.gbc.comp3095.gradeservice.controller;

import ca.gbc.comp3095.gradeservice.dto.GradeRequestDTO;
import ca.gbc.comp3095.gradeservice.dto.GradeResponseDTO;
import ca.gbc.comp3095.gradeservice.service.GradeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<GradeResponseDTO>> getAllGrades(){
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeResponseDTO> getGradeById(@PathVariable Long id){
        return ResponseEntity.ok(gradeService.getGradeById(id));
    }


    @PostMapping
    public ResponseEntity<GradeResponseDTO> createGrade(@Valid @RequestBody GradeRequestDTO dto){

        GradeResponseDTO created = gradeService.createGrade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // -- New endpoint: updateCourse() = update -- //
    @PutMapping("/{id}")
    public ResponseEntity<GradeResponseDTO> updateGrade(
            @PathVariable Long id,
            @Valid @RequestBody GradeRequestDTO dto){
        GradeResponseDTO updated = gradeService.updateGrade(id, dto);
        return ResponseEntity.ok(updated);
    }

    // -- New endpoint: deleteCourse() = delete -- //
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id){
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();   // 204 No Content
    }
}
