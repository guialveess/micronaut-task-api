package com.guiialves.application.port.in;

import com.guiialves.domain.model.Task;

public interface CreateTaskUseCase {
    Task create(String title, String description);
}