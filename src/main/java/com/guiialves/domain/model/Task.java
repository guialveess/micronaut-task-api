package com.guiialves.domain.model;

import com.guiialves.domain.exception.InvalidTaskException;
import com.guiialves.domain.exception.TaskAlreadyDoneException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean done;

    private Task(UUID id, String title, String description, LocalDateTime createdAt, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.done = done;
    }

    // chamador = isso vai vir da pessoa titulo e descricao
    public static Task create(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new InvalidTaskException("Title cannot be empty");
        }
        return new Task(UUID.randomUUID(), title, description, LocalDateTime.now(), false);
    }

    public static Task restore(UUID id, String title, String description, LocalDateTime createdAt, boolean done) {
        return new Task(id, title, description, createdAt, done);
    }

    public void complete() {
        if (isDone()) {
            throw new TaskAlreadyDoneException("Task already completed");
        }
        done = true;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isDone() {
        return done;
    }

    public static void main(String[] args) {
        var task = Task.create("Tentando", "Ir mais cedo!");
        task.complete();
        System.out.println(task);
    }
}
