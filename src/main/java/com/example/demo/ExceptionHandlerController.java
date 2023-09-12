package com.example.demo;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/errors")
public class ExceptionHandlerController {
    @Error(global = true)
    public HttpResponse<?> error(HttpRequest<?> request, Exception exception) {
        log.error("An error occurred on API endpoint {} {}: {}", request.getMethodName(),
                request.getUri(), exception.getMessage(), exception);

        return HttpResponse
                .status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
