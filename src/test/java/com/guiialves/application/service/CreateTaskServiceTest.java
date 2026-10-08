package com.guiialves.application.service;

import com.guiialves.application.port.out.TaskRepositoryPort;
import com.guiialves.domain.exception.InvalidTaskException;
import com.guiialves.domain.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

class CreateTaskServiceTest {

    // mock da porta de saída: uso quando vou testar o service (ou qualquer classe que dependa do repository) sem precisar de banco de dados.
    private final TaskRepositoryPort taskRepositoryPort = Mockito.mock(TaskRepositoryPort.class);

    // o service recebe o mock pelo construtor, então o teste roda só a lógica dele.
    private final CreateTaskService createTaskService = new CreateTaskService(taskRepositoryPort);

    @Test
    void shouldCreateTaskSave() {
        Mockito.when(taskRepositoryPort.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0)); // ensina o mock a devolver a própria task recebida no save
        Task task = createTaskService.create("Testando", "Testando");
        Assertions.assertEquals("Testando", task.getTitle());
        Assertions.assertEquals("Testando", task.getDescription());
        Mockito.verify(taskRepositoryPort).save(any(Task.class)); // confere que o save foi chamado (ou nunca, com never())
    }

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        assertThrows(InvalidTaskException.class, () -> {createTaskService.create(null, "Testando");});
        Mockito.verify(taskRepositoryPort, Mockito.never()).save(any(Task.class));
    }
}