package com.guiialves.infrastructure.in.web;

import com.guiialves.application.port.in.CreateTaskUseCase;
import com.guiialves.infrastructure.in.dto.CreateTaskRequestDto;
import com.guiialves.infrastructure.in.dto.CreateTaskResponseDto;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import jakarta.validation.Valid;

@Controller("/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskService;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskService = createTaskUseCase;
    }

    @Post
    @Status(HttpStatus.CREATED)
    public CreateTaskResponseDto createTask(@Body @Valid CreateTaskRequestDto request) {
        return CreateTaskResponseDto.from(createTaskService.create(request.title(), request.description()));
    }
}
