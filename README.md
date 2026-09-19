* Task Manager

A Spring Boot REST API for managing prioritized tasks.

The project started as a simple Java console-based Task Manager and was upgraded into a REST API using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL.

** Features

1. Create tasks with a description and priority
2. View pending tasks
3. View completed tasks
4. Automatically sort tasks by priority
5. Complete the highest-priority pending task
6. Store tasks in PostgreSQL
7. Validate incoming task data
8. Return useful validation error messages

** Technologies

1. Java
2. Spring Boot
3. Spring Web
4. Spring Data JPA
5. Hibernate
6. PostgreSQL
7. Maven

** Project Structure

```text
src/main/java/com/example/taskmanager
│
├── controller
│   └── TaskController
│
├── service
│   └── TaskManager
│
├── repository
│   └── TaskRepository
│
├── model
│   └── Task
│
├── exception
│   └── GlobalExceptionHandler
│
└── TaskManagerApplication
