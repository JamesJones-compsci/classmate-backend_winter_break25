package ca.gbc.comp3095.taskservice.service;

import ca.gbc.comp3095.taskservice.dto.TaskRequestDTO;
import ca.gbc.comp3095.taskservice.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO request);
    TaskResponseDTO getTaskById(String id);
    List<TaskResponseDTO> getAllTasks();
    TaskResponseDTO updateTask(String id, TaskRequestDTO request);
    void deleteTask(String id);
    List<TaskResponseDTO> getTasksByCompletionStatus(boolean completed);
}
