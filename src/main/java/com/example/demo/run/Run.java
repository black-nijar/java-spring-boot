package com.example.demo.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public record Run(String title, @Id Integer id, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles,
                Location location) {
};
