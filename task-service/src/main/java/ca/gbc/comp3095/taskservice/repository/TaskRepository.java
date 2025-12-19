package ca.gbc.comp3095.taskservice.repository;

import ca.gbc.comp3095.taskservice.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByCompleted(boolean completed);
}
