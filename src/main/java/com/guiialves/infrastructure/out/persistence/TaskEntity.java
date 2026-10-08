package com.guiialves.infrastructure.out.persistence;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@MappedEntity("tasks")
public class TaskEntity {

    @Id
    private UUID id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private boolean done;
}
