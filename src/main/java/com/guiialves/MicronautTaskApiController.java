package com.guiialves;


import io.micronaut.http.annotation.*;

@Controller("/micronaut-task-api")
public class MicronautTaskApiController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}