package com.example.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponse {

    private Integer id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private LocalDateTime dueDate;
    private String assignedTo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
