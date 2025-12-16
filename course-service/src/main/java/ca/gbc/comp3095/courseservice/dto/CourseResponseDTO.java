package ca.gbc.comp3095.courseservice.dto;

/*
 * Purpose:
 *        - Prevent exposing internal DB structure
 *        - Allow API evolution without breaking clients
 *
 * Request DTO has validation
 * Response DTO is read-only
 * No setters in response DTO -> immutability
 */

public class CourseResponseDTO {

    private Long id;
    private String code;
    private String title;
    private String description;

    public CourseResponseDTO(Long id, String code, String title, String description){
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
