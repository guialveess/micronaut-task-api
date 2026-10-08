package com.guiialves.infrastructure.out.persistence;

import com.guiialves.domain.model.Task;

// converte entre task (domínio) e taskEntity (banco), para o domínio não conhecer o banco.
public class TaskMapper {

    // ao salvar: task ≥ linha do banco
    public static TaskEntity toEntity(Task task) {
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreatedAt(), task.isDone());
    }

    // ao ler: linha do banco ≥ task
    public static Task toDomain(TaskEntity entity) {
        return Task.restore(entity.getId(), entity.getTitle(), entity.getDescription(),
                entity.getCreatedAt(), entity.isDone());
    }
}
