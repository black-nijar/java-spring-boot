package com.example.demo.run;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface RunReposity extends ListCrudRepository<Run, Integer>{


    List<Run> findAllByLocation(String location); 
}
