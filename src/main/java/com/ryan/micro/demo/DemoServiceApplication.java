package com.ryan.micro.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class DemoServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        log.info("DemoServiceApplication#main");
        SpringApplication.run(DemoServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "curl -v http://localhost:9000/demo").inheritIO(); // 需要使用 inheritIO
                    Process p = pb.start();
                    p.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
