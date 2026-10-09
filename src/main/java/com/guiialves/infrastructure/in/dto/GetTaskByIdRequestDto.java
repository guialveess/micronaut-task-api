package com.guiialves.infrastructure.in.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Serdeable
public record GetTaskByIdRequestDto(
        @NotNull
        UUID id
) {
}
