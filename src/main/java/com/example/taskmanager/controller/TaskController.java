package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.taskmanager.service.TaskManager;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskManager taskManager;

    public TaskController(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @GetMapping()
    public List<Task> handlePending() {
        return taskManager.getPendingTasks();
    }

    @GetMapping("/completed")
    public List<Task> handleCompleted() {
        return taskManager.getCompletedTasks();
    }

    @PostMapping()
    public ResponseEntity<String> postTask(@RequestBody @Valid Task task) {
        taskManager.addTask(task.getDescription(), task.getPriority());
        return ResponseEntity.status(HttpStatus.CREATED).body("Added");
    }

    @PostMapping("/completed-Task")
    public ResponseEntity<String> completeTask() {
        boolean check = taskManager.completeNextTask();
        if(check) {
            return ResponseEntity.ok("Completed");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Pending Task");
    }
}