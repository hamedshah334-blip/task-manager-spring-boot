package com.example.taskmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank()
    private String description;

    @Min(1)
    @Max(3)
    private int priority; //1 = High,2 = Medium,3 = Low

    private boolean completed;

    public Task() {
    }
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }
    public long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public int getPriority() {
        return priority;
    }
    public boolean getCompletion() {
        return completed;
    }
    public void setCompletion() {
        this.completed = true;
    }
}
