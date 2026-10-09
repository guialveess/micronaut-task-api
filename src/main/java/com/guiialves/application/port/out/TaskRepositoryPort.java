package com.guiialves.application.port.out;

import com.guiialves.domain.model.Task;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> get(UUID id);
}
