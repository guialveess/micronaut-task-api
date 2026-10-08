package com.guiialves.infrastructure.in.dto;

import com.guiialves.domain.model.Task;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;
import java.util.UUID;

@Serdeable
public record CreateTaskResponseDto(
        UUID id,
        String title,
        String description,
        LocalDateTime createdAt,
        boolean done

) {

    public static CreateTaskResponseDto from(Task task) {
        return new CreateTaskResponseDto(task.getId(), task.getTitle(), task.getDescription(),
                task.getCreatedAt(), task.isDone());
    }
}
