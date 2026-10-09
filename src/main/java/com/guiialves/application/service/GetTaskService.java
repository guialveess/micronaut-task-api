package com.guiialves.application.service;

import com.guiialves.application.port.in.GetTaskUseCase;
import com.guiialves.application.port.out.TaskRepositoryPort;
import com.guiialves.domain.model.Task;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class GetTaskService implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public GetTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task get(UUID id) {
        return taskRepositoryPort.get(id).orElseThrow(() -> new RuntimeException
                ("No task found with id: " + id));
    }
}
