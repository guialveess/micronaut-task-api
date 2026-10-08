package com.guiialves.application.service;

import com.guiialves.application.port.in.CreateTaskUseCase;
import com.guiialves.application.port.out.TaskRepositoryPort;
import com.guiialves.domain.model.Task;
import jakarta.inject.Singleton;

@Singleton
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task create(String title, String description) {
        return taskRepositoryPort.save(Task.create(title, description));
    }
}
