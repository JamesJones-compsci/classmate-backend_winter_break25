package ca.gbc.comp3095.gradeservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String courseName;

    private String type; // Example: Exam, Quiz, Assignment, etc.

    private double grade;
    private double weight;

    private String feedback;

    // JPA requires a no-args constructor (shows an error if not added)
    protected Grade() {}

    public Grade(String courseCode, String courseName, String type,
                 double grade, double weight, String feedback){

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
