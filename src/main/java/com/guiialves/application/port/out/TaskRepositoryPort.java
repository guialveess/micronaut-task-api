package com.guiialves.application.port.out;

import com.guiialves.domain.model.Task;

public interface TaskRepositoryPort {
    Task save(Task task);
}
