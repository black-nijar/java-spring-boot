package com.example.demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.DemoApplication;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
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

    void create(Run run) {
        runs.add(run);
    }

    void updateById(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        log.info("update "+ existingRun);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void deleteById(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
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