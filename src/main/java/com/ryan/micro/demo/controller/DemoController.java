package com.ryan.micro.demo.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@Slf4j
public class DemoController {

    @Resource
    private DataSource dataSource;

    @GetMapping(value = "/demo")
    public ResponseEntity<String> demo() {
        log.info("DemoController#demo >>>> {}", "demo");
        log.info("[] >>>> ds = {}", dataSource);
        return ResponseEntity.ok("Hello,GraalVM");
    }
}
