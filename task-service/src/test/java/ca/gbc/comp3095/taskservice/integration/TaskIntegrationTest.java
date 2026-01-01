package ca.gbc.comp3095.taskservice.integration;

import ca.gbc.comp3095.taskservice.model.Task;
import ca.gbc.comp3095.taskservice.repository.TaskRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class TaskIntegrationTest {

    @Container
    static MongoDBContainer mongo =
            new MongoDBContainer("mongo:7");

    @DynamicPropertySource
    static void configureMongo(DynamicPropertyRegistry registry) {
        registry.add(
                "spring.data.mongodb.uri",
                mongo::getReplicaSetUrl
        );
    }

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldPersistAndLoadTask() {
        Task task = new Task(
                "Write integration tests",
                "Practice Testcontainers",
                false
        );

        taskRepository.save(task);

        assertThat(taskRepository.findAll()).hasSize(1);
    }
}
