package com.example;

import com.example.demo.BodyDto;
import com.example.demo.ConcreteValidator;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class WorksDemoTest {
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testItWorks() {
        BodyDto bodyDto = BodyDto.builder()
            .concreteValidator(ConcreteValidator.makeDefault())
            .build();

        HttpResponse<BodyDto> response = client
            .toBlocking()
            .exchange(HttpRequest.create(HttpMethod.POST, "/api")
                .body(bodyDto), BodyDto.class);

        Assertions.assertEquals(bodyDto, response.body());
    }
}
