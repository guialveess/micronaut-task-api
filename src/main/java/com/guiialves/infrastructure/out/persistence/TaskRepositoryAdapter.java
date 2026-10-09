package com.guiialves.infrastructure.out.persistence;

import com.guiialves.application.port.out.TaskRepositoryPort;
import com.guiialves.domain.model.Task;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskJdbcRepository taskJdbcRepository;

    public TaskRepositoryAdapter(TaskJdbcRepository taskJdbcRepository) {
        this.taskJdbcRepository = taskJdbcRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity entity = TaskMapper.toEntity(task);
        TaskEntity saved = taskJdbcRepository.save(entity);
        return TaskMapper.toDomain(saved);
    }

    @Override
    public Optional<Task> get(UUID id) {
        return taskJdbcRepository.findById(id)
                .map(TaskMapper::toDomain);
    }

    @Override
    public List<Task> getAll() {
        return taskJdbcRepository.findAll()
                .stream()
                .map(TaskMapper::toDomain)
                .toList();
    }
}
