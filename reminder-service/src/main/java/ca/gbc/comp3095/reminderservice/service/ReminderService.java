package ca.gbc.comp3095.reminderservice.service;


import ca.gbc.comp3095.reminderservice.dto.ReminderRequestDTO;
import ca.gbc.comp3095.reminderservice.dto.ReminderResponseDTO;

import java.util.List;

public interface ReminderService {

    ReminderResponseDTO createReminder(ReminderRequestDTO requestDTO);
    ReminderResponseDTO getReminderById(String id);
    List<ReminderResponseDTO> getAllReminders();
    ReminderResponseDTO updateReminder(String id, ReminderRequestDTO requestDTO);
    void deleteReminder(String id);
}
