package com.example.demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    List<Run> updateAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run("Monday", 1, LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 4,
                Location.INDOOR));
        runs.add(new Run("Tuesday", 2, LocalDateTime.now(), LocalDateTime.now().plus(40, ChronoUnit.MINUTES), 4,
                Location.INDOOR));
        runs.add(new Run("Wednesday", 3, LocalDateTime.now(), LocalDateTime.now().plus(50, ChronoUnit.MINUTES), 4,
                Location.INDOOR));
    }
}