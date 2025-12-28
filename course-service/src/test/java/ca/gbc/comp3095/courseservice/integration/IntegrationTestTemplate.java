package ca.gbc.comp3095.courseservice.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import ca.gbc.comp3095.courseservice.repository.CourseRepository;
import ca.gbc.comp3095.gradeservice.repository.GradeRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class IntegrationTestTemplate {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @Container
    static MongoDBContainer mongo = new MongoDBContainer("mongo:7");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);

        registry.add("spring.data.mongodb.uri", mongo::getReplicaSetUrl);
    }

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Test
    void testPostgresRepository() {
        courseRepository.save(new ca.gbc.comp3095.courseservice.model.Course("Test Course"));
        assertThat(courseRepository.findAll()).isNotEmpty();
    }

    @Test
    void testMongoRepository() {
        gradeRepository.save(new ca.gbc.comp3095.gradeservice.model.Grade("Test Grade"));
        assertThat(gradeRepository.findAll()).isNotEmpty();
    }
}
