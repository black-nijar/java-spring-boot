package com.example.demo;

import com.example.demo.run.Run;
import com.example.demo.run.Location;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        log.info("printing logs");

    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Run run = new Run("First", 1, LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 1,
                    Location.OUTDOOR);
            log.info("run : " + run);
        };
    };
}
