package com.example.demo.run;

import java.time.LocalDateTime;

public record Run(String title, Integer id, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles,
        Location location) {
};
