package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskManager {
    private TaskRepository taskRepository;

    public TaskManager(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String description, int priority) {
        Task task = new Task(description, priority);
        taskRepository.save(task);
    }

    public boolean completeNextTask() {
        Optional<Task> result = taskRepository.findFirstByCompletedFalseOrderByPriorityAsc();
        if(result.isEmpty()) {
            return false;
        }
        Task task = result.get();
        task.setCompletion();
        taskRepository.save(task);
        return true;
    }

    public List<Task> getPendingTasks() {
        return taskRepository.findAllByCompletedFalseOrderByPriorityAsc();
    }
    public List<Task> getCompletedTasks() {
        return taskRepository.findAllByCompletedTrueOrderByPriorityAsc();
    }
}