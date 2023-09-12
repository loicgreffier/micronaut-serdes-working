package com.example.demo;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/api")
public class MyController {

    @Post
    public BodyDto apply(@Valid @Body BodyDto bodyDto) {
        log.info("Body is " + bodyDto);
        return bodyDto;
    }
}
