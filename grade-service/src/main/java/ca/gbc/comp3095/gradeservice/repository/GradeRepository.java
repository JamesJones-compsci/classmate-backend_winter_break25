package ca.gbc.comp3095.gradeservice.repository;

import ca.gbc.comp3095.gradeservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
