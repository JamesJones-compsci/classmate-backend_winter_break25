package ca.gbc.comp3095.taskservice.service;


import ca.gbc.comp3095.taskservice.dto.TaskResponseDTO;
import ca.gbc.comp3095.taskservice.dto.TaskRequestDTO;
import ca.gbc.comp3095.taskservice.exception.TaskNotFoundException;
import ca.gbc.comp3095.taskservice.model.Task;
import ca.gbc.comp3095.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO request){
        Task task = new Task(request.getTitle(), request.getDescription(), request.isCompleted());
        Task saved = repository.save(task);
        return mapToResponse(saved);
    }

    @Override
    public TaskResponseDTO getTaskById(String id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        return mapToResponse(task);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks(){
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDTO updateTask(String id, TaskRequestDTO request){
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        Task updated = repository.save(task);
        return mapToResponse(updated);
    }

    @Override
    public void deleteTask(String id){
        if(!repository.existsById(id)){
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<TaskResponseDTO> getTasksByCompletionStatus(boolean completed){
        return repository.findByCompleted(completed)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private TaskResponseDTO mapToResponse(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }
}
