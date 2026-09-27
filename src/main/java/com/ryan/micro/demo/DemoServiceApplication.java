package com.ryan.micro.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class DemoServiceApplication {

    public static void main(String[] args) {
        log.info("DemoServiceApplication#main");
        SpringApplication.run(DemoServiceApplication.class, args);
    }
}
