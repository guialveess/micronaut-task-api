package com.guiialves.application.service;

import com.guiialves.application.port.in.ListTasksUseCase;
import com.guiialves.application.port.out.TaskRepositoryPort;
import com.guiialves.domain.model.Task;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ListTaskService implements ListTasksUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public ListTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public List<Task> getAll() {
        return taskRepositoryPort.getAll();
    }
}
