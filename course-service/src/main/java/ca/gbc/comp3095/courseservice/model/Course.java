package ca.gbc.comp3095.courseservice.model;

// Purpose: Represent how course data is stored internally, NOT how it's exposed

// @Entity -> JPA-managed persistence
// @Table(name = "courses") -> explicit DB mapping
// No validation annotations here -> entities are NOT API contracts

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String title;

    private String description;

    // Constructors
    public Course() {}

    public Course(String code, String title, String description){
        this.code = code;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

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
