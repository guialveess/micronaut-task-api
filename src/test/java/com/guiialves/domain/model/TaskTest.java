package com.guiialves.domain.model;

import com.guiialves.domain.exception.InvalidTaskException;
import com.guiialves.domain.exception.TaskAlreadyDoneException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void shouldCreateTaskNotDone() {
        Task task = Task.create("Testando", "Testando");
        assertNotNull(task.getId()); // id não é null
        assertNotNull(task.getCreatedAt()); // dataDeCriacao não é null
        assertFalse(task.isDone()); // passa quando o valor é false
    }

    @Test
    void shouldNotCreateTaskWithoutTitle() {
        assertThrows(InvalidTaskException.class, ()
                -> Task.create("", "Testando"));
    }

    @Test
    void shouldMarkTaskAsDone() {
        Task task = Task.create("Testando", "Testando");
        task.complete();
        assertTrue(task.isDone());
    }

    @Test
    void shouldNotCompleteTaskTwice() {
        Task task = Task.create("Testando", "Testando");
        task.complete();
        assertThrows(TaskAlreadyDoneException.class, ()
                -> task.complete());
    }
}