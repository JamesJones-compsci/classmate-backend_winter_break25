package ca.gbc.comp3095.reminderservice.exception;

public class ReminderNotFoundException extends RuntimeException{

    public ReminderNotFoundException(String message) {
        super(message);
    }
}
