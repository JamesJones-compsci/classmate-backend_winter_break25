package ca.gbc.comp3095.gradeservice.dto;

public class GradeResponseDTO {

    private Long id;
    private String courseCode;
    private String courseName;
    private String type;
    private double grade;
    private double weight;
    private String feedback;

    public GradeResponseDTO() {}

    // -- Complete / Full Constructor needed for the Service layer -- //
    public GradeResponseDTO(Long id, String courseCode, String courseName, String type, double grade, double weight, String feedback) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.type = type;
        this.grade = grade;
        this.weight = weight;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getType() {
        return type;
    }

    public double getGrade() {
        return grade;
    }

    public double getWeight() {
        return weight;
    }

    public String getFeedback() {
        return feedback;
    }
}
