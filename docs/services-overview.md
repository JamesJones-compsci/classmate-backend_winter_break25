# Backend Services Overview

This document provides a consolidated reference for all backend services in the **Classmate Backend Project**. It includes container details, ports, JVM versions, health endpoints, and notes for debugging or onboarding.

---

## Services Table

| Service Name    | Image & Tag                          | Container Name    | Port  | JDK Version | JAVA_OPTS | Health Endpoint   | Notes |
|-----------------|-------------------------------------|-----------------|-------|------------|-----------|-------------------|-------|
| CourseService   | classmate-backend_winter_break25-course-service:latest | course-service    | 8080/8084 | 21.0.9     | (none)    | /api/v1/courses   | Uses course-service container; mapped to 8084 externally |
| GradeService    | classmate-backend_winter_break25-grade-service:latest  | grade-service     | 8081/8085 | 21.0.9     | (none)    | /api/v1/grades    | Updated log line: "Health check OK!" |
| ReminderService | classmate-backend_winter_break25-reminder-service:latest | reminder-service | 8082/8087 | 21.0.9     | (none)    | /api/v1/reminders | Ensure internal DNS works for service-to-service communication |
| TaskService     | classmate-backend_winter_break25-task-service:latest   | task-service      | 8083/8086 | 21.0.9     | (none)    | /api/v1/tasks     | Maps to external port 8086; used for task management |

---

## Notes and Recommendations

1. **Rebuild Tracking**
    - Last rebuild (GradeService): 2025-12-22 02:00
    - Last rebuild (ReminderService): N/A
    - Last rebuild (CourseService): N/A
    - Last rebuild (TaskService): N/A

2. **Memory Usage**
    - Monitor via `docker stats` for each container; useful for performance tuning.

3. **Environment Variables**
    - JAVA_OPTS currently not set.
    - Add service-specific variables in `docker-compose.override.yml` if needed.

4. **Health Checks**
    - Confirm container connectivity via internal DNS:
      ```bash
      curl http://grade-service:8081/health
      curl http://reminder-service:8082/health
      curl http://task-service:8083/health
      curl http://course-service:8080/health
      ```
    - Internal Docker networking is confirmed functional.

5. **Notes on Ports**
    - Each container exposes an internal port (`:`) and an external mapped port (`host:container`) in Docker.
    - External ports are used for local testing.

6. **Optional**
    - Track service-specific changes, rebuild commands, and log messages here for historical reference.
    - Update this document whenever new services are added or ports/JVM versions change.

---

**Maintainer:** James Jones  
**Project:** Classmate Backend Winter Break 2025
