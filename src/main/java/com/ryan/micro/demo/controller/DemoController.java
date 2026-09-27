package com.ryan.micro.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping(value = "/demo")
    public ResponseEntity<String> demo() {
        log.info("【】>>>> {}", "demo");
        return ResponseEntity.ok("Hello,GraalVM");
    }
}
