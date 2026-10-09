package com.guiialves.infrastructure.in.web;

import com.guiialves.application.port.in.CreateTaskUseCase;
import com.guiialves.application.port.in.GetTaskUseCase;
import com.guiialves.application.port.in.ListTasksUseCase;
import com.guiialves.infrastructure.in.dto.CreateTaskRequestDto;
import com.guiialves.infrastructure.in.dto.GetTaskByIdRequestDto;
import com.guiialves.infrastructure.in.dto.TaskResponseDto;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import jakarta.validation.Valid;

import java.util.List;

@Controller("/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskService;
    private final GetTaskUseCase getTaskService;
    private final ListTasksUseCase listTasksService;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTaskService,
                           ListTasksUseCase listTasksService) {
        this.createTaskService = createTaskUseCase;
        this.getTaskService = getTaskService;
        this.listTasksService = listTasksService;
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public TaskResponseDto createTask(@Body @Valid CreateTaskRequestDto request) {
        return TaskResponseDto.from(createTaskService.create(request.title(), request.description()));
    }

    @Post
    @Status(HttpStatus.OK)
    public TaskResponseDto getTask(@Body @Valid GetTaskByIdRequestDto request) {
        return TaskResponseDto.from(getTaskService.get(request.id()));
    }

    @Get
    @Status(HttpStatus.OK)
    public List<TaskResponseDto> getAllTasks() {
        return listTasksService.getAll()
                .stream()
                .map(TaskResponseDto::from)
                .toList();
    }
}
