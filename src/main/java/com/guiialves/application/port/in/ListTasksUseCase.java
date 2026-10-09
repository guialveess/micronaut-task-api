package com.guiialves.application.port.in;

import com.guiialves.domain.model.Task;

import java.util.List;

public interface ListTasksUseCase {
    List<Task> getAll();
}
