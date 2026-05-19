package org.acme.demo.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {

    private final String endpointsJson;

    public HomeController(@Value("classpath:endpoints.json") Resource endpointsResource) throws IOException {
        this.endpointsJson = endpointsResource.getContentAsString(StandardCharsets.UTF_8);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> home() {
        log.info("Displaying endpoints");
        return ResponseEntity.ok(endpointsJson);
    }
}
