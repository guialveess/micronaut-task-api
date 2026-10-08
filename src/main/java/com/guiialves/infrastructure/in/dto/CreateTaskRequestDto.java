package com.guiialves.infrastructure.in.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Serdeable
public record CreateTaskRequestDto(
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255)
        String title,

        @NotBlank(message = "Description cannot be blank")
        String description
) {
}
