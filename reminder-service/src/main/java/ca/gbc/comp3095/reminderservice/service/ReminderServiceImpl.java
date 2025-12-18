package ca.gbc.comp3095.reminderservice.service;


import ca.gbc.comp3095.reminderservice.dto.ReminderRequestDTO;
import ca.gbc.comp3095.reminderservice.dto.ReminderResponseDTO;
import ca.gbc.comp3095.reminderservice.exception.ReminderNotFoundException;
import ca.gbc.comp3095.reminderservice.model.Reminder;
import ca.gbc.comp3095.reminderservice.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository repository;

    @Override
    public ReminderResponseDTO createReminder(ReminderRequestDTO request){
        Reminder reminder = new Reminder(
                request.getTitle(),
                request.getAssociatedTask(),
                request.getCourse(),
                request.getPriority(),
                request.getAlertDate(),
                request.getAlertTime(),
                request.getNote(),
                request.getTaskId(),
                request.getCourseId()
        );
        Reminder saved = repository.save(reminder);
        return mapToResponse(saved);
    }

    @Override
    public ReminderResponseDTO getReminderById(String id){
        Reminder reminder = repository.findById(id)
                .orElseThrow(() -> new ReminderNotFoundException("Reminder not found with id: " + id));
        return mapToResponse(reminder);
    }

    @Override
    public List<ReminderResponseDTO> getAllReminders(){
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    @Override
    public ReminderResponseDTO updateReminder(String id, ReminderRequestDTO request){
        Reminder reminder = repository.findById(id)
                .orElseThrow(() -> new ReminderNotFoundException("Reminder not found with id: " + id));

        reminder.setTitle(request.getTitle());
        reminder.setAssociatedTask(request.getAssociatedTask());
        reminder.setCourse(request.getCourse());
        reminder.setPriority(request.getPriority());
        reminder.setAlertDate(request.getAlertDate());
        reminder.setAlertTime(request.getAlertTime());
        reminder.setNote(request.getNote());
        reminder.setTaskId(request.getTaskId());
        reminder.setCourseId(request.getCourseId());

        Reminder updated = repository.save(reminder);
        return mapToResponse(updated);
    }


    @Override
    public void deleteReminder(String id){
        if(!repository.existsById(id)){
            throw new ReminderNotFoundException("Reminder not found with id: " + id);
        }
        repository.deleteById(id);
    }


    private ReminderResponseDTO mapToResponse(Reminder reminder){
        return new ReminderResponseDTO(
                reminder.getId(),
                reminder.getTitle(),
                reminder.getAssociatedTask(),
                reminder.getCourse(),
                reminder.getPriority(),
                reminder.getAlertDate(),
                reminder.getAlertTime(),
                reminder.getNote(),
                reminder.getTaskId(),
                reminder.getCourseId()
        );
    }
}
