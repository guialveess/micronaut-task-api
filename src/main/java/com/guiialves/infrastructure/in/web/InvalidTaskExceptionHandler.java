package com.guiialves.infrastructure.in.web;

import com.guiialves.domain.exception.InvalidTaskException;
import com.guiialves.infrastructure.in.dto.ErrorResponse;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Produces
public class InvalidTaskExceptionHandler implements ExceptionHandler<InvalidTaskException, HttpResponse<?>> {

    @Override
    public HttpResponse<?> handle(HttpRequest request, InvalidTaskException exception) {
        return HttpResponse.badRequest(new ErrorResponse(exception.getMessage()));
    }
}