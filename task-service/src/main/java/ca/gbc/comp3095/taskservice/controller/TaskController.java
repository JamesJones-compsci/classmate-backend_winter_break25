package ca.gbc.comp3095.taskservice.controller;


import ca.gbc.comp3095.taskservice.dto.TaskRequestDTO;
import ca.gbc.comp3095.taskservice.dto.TaskResponseDTO;
import ca.gbc.comp3095.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO request) {
        return service.createTask(request);
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable String id) {
        return service.getTaskById(id);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/completed/{status}")
    public List<TaskResponseDTO> getTasksByCompletion(@PathVariable boolean status) {
        return service.getTasksByCompletionStatus(status);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable String id,
                                      @RequestBody TaskRequestDTO request) {
        return service.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        service.deleteTask(id);
    }





}
