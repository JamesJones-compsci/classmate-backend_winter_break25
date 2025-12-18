package ca.gbc.comp3095.reminderservice.dto;

public class ReminderResponseDTO {
    private String id;
    private String title;
    private String associatedTask;
    private String course;
    private String priority;
    private String alertDate;
    private String alertTime;
    private String note;
    private Integer taskId;
    private Integer courseId;

    // Constructor
    public ReminderResponseDTO(String id, String title, String associatedTask, String course, String priority,
                    String alertDate, String alertTime, String note, Integer taskId, Integer courseId){
        this.id = id;
        this.title = title;
        this.associatedTask = associatedTask;
        this.course = course;
        this.priority = priority;
        this.alertDate = alertDate;
        this.alertTime = alertTime;
        this.note = note;
        this.taskId = taskId;
        this.courseId = courseId;
    }

    // Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssociatedTask() {
        return associatedTask;
    }

    public void setAssociatedTask(String associatedTask) {
        this.associatedTask = associatedTask;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(String alertDate) {
        this.alertDate = alertDate;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
