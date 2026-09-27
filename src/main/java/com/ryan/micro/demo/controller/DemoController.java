package com.ryan.micro.demo.controller;

import com.ryan.micro.demo.model.User;
import com.ryan.micro.demo.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/demo")
    public ResponseEntity<String> demo() {
        log.info("DemoController#demo >>>> {}", "demo");
        User user = new User();
        user.setUserId("james");
        user.setNickname("Ricky.Lee");
        log.info("[] >>>> result = {}", userService.save(user));
        return ResponseEntity.ok("Hello,GraalVM");
    }
}
