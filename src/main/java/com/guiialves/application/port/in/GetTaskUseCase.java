package com.guiialves.application.port.in;

import com.guiialves.domain.model.Task;

import java.util.UUID;

public interface GetTaskUseCase {
    Task get(UUID id);
}
