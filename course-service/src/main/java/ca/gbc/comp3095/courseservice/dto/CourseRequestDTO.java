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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class CourseRequestDTO {


    @NotBlank(message = "Course code is required")
    @Size(max = 10, message = "Course code must be at most 10 characters")
    private String code;

    @NotBlank(message = "Course title is required")
    private String title;

    private String description;

    // Getters and Setters
    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
