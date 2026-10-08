package com.guiialves.infrastructure.in.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ErrorResponse(String message) {
}