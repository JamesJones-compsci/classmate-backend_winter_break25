package ca.gbc.comp3095.gradeservice.exception;

public class GradeNotFoundException extends RuntimeException {

    public GradeNotFoundException(Long id) {
        super("Grade not found with id: " + id);
    }
}
