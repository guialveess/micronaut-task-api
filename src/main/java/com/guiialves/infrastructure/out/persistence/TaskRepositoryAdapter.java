package com.guiialves.infrastructure.out.persistence;

import com.guiialves.application.port.out.TaskRepositoryPort;
import com.guiialves.domain.model.Task;
import jakarta.inject.Singleton;

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
}