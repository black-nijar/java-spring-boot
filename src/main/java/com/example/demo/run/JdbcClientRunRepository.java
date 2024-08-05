package com.example.demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.example.demo.DemoApplication;

@Repository
public class JdbcClientRunRepository {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    private List<Run> runs = new ArrayList<>();

    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    List<Run> findAll() {
        return jdbcClient.sql("select * from run").query(Run.class).list();
    }

    Optional<Run> findById(Integer id) {
        return jdbcClient.sql("select * from run where id = :id").param("id", id).query(Run.class).optional();
    }

    // List<Run> updateAll() {
    // return runs;
    // }

    public void create(Run run) {
        jdbcClient.sql(
                "insert into Run (id, title, miles, started_on, completed_on, location) values (?,?,?,?,?,?)")
                .params(List.of(run.id(), run.title(), run.miles(), run.startedOn(), run.completedOn(),
                        run.location().toString()))
                .update();
    }

    public void updateById(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        log.info("update " + existingRun);
        if (existingRun.isPresent()) {
            jdbcClient.sql("update  run set title=?, miles=?, completed_on=?, started_on=?, location=? where id=?")
                    .params(List.of(run.title(), run.miles(), run.completedOn(), run.startedOn(),
                            run.location().toString(), id))
                    .update();
        }
    }

    public int count() {
        return jdbcClient.sql("select * from run").query().listOfRows().size();
    }

    public void deleteById(Integer id) {
        jdbcClient.sql("delete from run where id= :id").param("id", id).update();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }
}