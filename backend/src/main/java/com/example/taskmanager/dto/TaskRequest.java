package com.example.taskmanager.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be <= 100 characters")
    private String title;

    private String description;

    private Boolean isCompleted;

    private LocalDateTime dueDate;

    private String assignedTo;
}
