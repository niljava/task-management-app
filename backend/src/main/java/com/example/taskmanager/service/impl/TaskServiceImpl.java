package com.example.taskmanager.service.impl;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Override
    public TaskResponse create(TaskRequest request) {
        Task saved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }

    @Override
    public TaskResponse update(Integer id, TaskRequest request) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        mapper.updateEntity(task, request);
        return mapper.toResponse(task);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found")));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TaskResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public TaskResponse toggleStatus(Integer id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setIsCompleted(!task.getIsCompleted());
        return mapper.toResponse(task);
    }
}
