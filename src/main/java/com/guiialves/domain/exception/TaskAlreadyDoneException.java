package com.guiialves.domain.exception;

public class TaskAlreadyDoneException extends RuntimeException {
    public TaskAlreadyDoneException(String message) {
        super(message);
    }
}
