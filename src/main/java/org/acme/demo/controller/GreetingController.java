package org.acme.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

    private final String appName;

    public GreetingController(@Value("${spring.application.name}") String appName) {
        this.appName = appName;
    }

    @GetMapping
    public ResponseEntity<String> getGreeting() {
        log.info("Getting greeting");
        return ResponseEntity.ok("Greetings from %s".formatted(appName));
    }
    
}
