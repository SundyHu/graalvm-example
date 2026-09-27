package com.ryan.micro.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoServiceApplication {

    public static void main(String[] args) {
        log.info("DemoServiceApplication#main");
        SpringApplication.run(DemoServiceApplication.class, args);
    }
}
