package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponse create(TaskRequest request);

    TaskResponse update(Integer id, TaskRequest request);

    TaskResponse getById(Integer id);

    Page<TaskResponse> getAll(Pageable pageable);

    void delete(Integer id);

    TaskResponse toggleStatus(Integer id);
}
