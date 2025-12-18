package ca.gbc.comp3095.reminderservice.repository;

import ca.gbc.comp3095.reminderservice.model.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends MongoRepository<Reminder, String> {

    List<Reminder> findByCourseId(Integer courseId);
    List<Reminder> findByTaskId(Integer taskId);
}
