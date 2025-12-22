ClassMate Backend Architecture — Day 8 Documentation
1. Executive Summary

Project Objective:
The ClassMate project aims to design and develop a web-based student life management platform that 
streamlines academic planning and organization. Through features such as grade tracking, assignment scheduling, 
progress monitoring, and customizable notifications, the system will enable students to effectively manage 
their coursework and deadlines.

Corporate Goals Addressed:

Provide a flexible, scalable platform for student management

Support productivity and academic success

Build sustainable tools adaptable to emerging educational trends

Planned Timeline:

Start: Monday, January 5, 2026

End: Friday, April 10, 2026

2. Microservice Boundaries & Data Ownership
   Service	Database Type	Responsibility / Owned Data
   course-service	PostgreSQL	Courses, course details, course lists
   grade-service	PostgreSQL	Grades, grade calculations, per-course grade data
   task-service	MongoDB	Tasks, task metadata, user task lists
   reminder-service	MongoDB	Reminders, notifications, scheduling for tasks and events
   api-gateway	N/A	Routes incoming requests to appropriate services; handles versioning and 
   authentication (optional at Day 8)

Rule: Each service owns its own database; no direct cross-service DB access.

3. Communication Patterns
   Synchronous Communication (REST API)

Services call each other via REST endpoints when immediate response is needed.

Example:

grade-service → course-service: retrieve course info by ID for grade assignment

reminder-service → task-service: fetch task details to generate reminders

Asynchronous Communication (Future/Optional)

Event-driven or message queues (e.g., RabbitMQ, Kafka)

Example:

task-service publishes “task-completed” → reminder-service triggers notification

Notes: Sync is implemented via REST endpoints; async is optional/future feature.

4. Service Endpoints (Sketch)
   4.1 Course-Service
   Method	Endpoint	Description
   GET	/api/v1/courses	List all courses
   POST	/api/v1/courses	Add new course
   GET	/api/v1/courses/{id}	Get course by ID
   PUT	/api/v1/courses/{id}	Update course info
   DELETE	/api/v1/courses/{id}	Delete course
   4.2 Grade-Service
   Method	Endpoint	Description
   GET	/api/v1/grades	List all grades
   POST	/api/v1/grades	Add new grade
   GET	/api/v1/grades/{id}	Get grade by ID
   PUT	/api/v1/grades/{id}	Update grade
   DELETE	/api/v1/grades/{id}	Delete grade
   4.3 Task-Service
   Method	Endpoint	Description
   GET	/api/v1/tasks	List all tasks
   POST	/api/v1/tasks	Add new task
   GET	/api/v1/tasks/{id}	Get task by ID
   PUT	/api/v1/tasks/{id}	Update task
   DELETE	/api/v1/tasks/{id}	Delete task
   4.4 Reminder-Service
   Method	Endpoint	Description
   GET	/api/v1/reminders	List all reminders
   POST	/api/v1/reminders	Add new reminder
   GET	/api/v1/reminders/{id}	Get reminder by ID
   PUT	/api/v1/reminders/{id}	Update reminder
   DELETE	/api/v1/reminders/{id}	Delete reminder
   4.5 API Gateway (Skeleton)

Folder: api-gateway/src/main/java/com/classmate/gateway/

Purpose: Route requests to individual services, handle versioning and auth.

Endpoints (placeholder, Day 8):

/api/v1/courses → course-service

/api/v1/grades → grade-service

/api/v1/tasks → task-service

/api/v1/reminders → reminder-service

Implementation will occur in Day 9.

5. Activity Diagram References
   Feature	Activity Diagram File / Reference
   Courses	Course Activity Diagram
   Tasks	Task Activity Diagram
   Reminders	Reminder Activity Diagram
   Grades	Grade Activity Diagram
   GPA	User / GPA Activity Diagram (optional)

Note: Diagrams are vertical, top-down layout. Decision nodes for validation loops in tasks and reminders.