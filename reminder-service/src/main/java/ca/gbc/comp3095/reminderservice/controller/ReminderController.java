package ca.gbc.comp3095.reminderservice.controller;


import ca.gbc.comp3095.reminderservice.dto.ReminderRequestDTO;
import ca.gbc.comp3095.reminderservice.dto.ReminderResponseDTO;
import ca.gbc.comp3095.reminderservice.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/reminders")
public class ReminderController {

    @Autowired
    private ReminderService service;

    @PostMapping
    public ReminderResponseDTO createReminder(@RequestBody ReminderRequestDTO request) {
        return service.createReminder(request);
    }

    @GetMapping("/{id}")
    public ReminderResponseDTO getReminderById(@PathVariable String id) {
        return service.getReminderById(id);
    }


    @GetMapping
    public List<ReminderResponseDTO> getAllReminders(){
        return service.getAllReminders();
    }

    @PutMapping("/{id}")
    public ReminderResponseDTO updateReminder(@PathVariable String id,
                                              @RequestBody ReminderRequestDTO request) {
        return service.updateReminder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable String id) {
        service.deleteReminder(id);
    }



}
