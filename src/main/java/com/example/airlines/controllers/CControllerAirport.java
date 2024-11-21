package com.example.airlines.controllers;

import com.example.airlines.model.CAirport;
import com.example.airlines.repositories.IRepositoryAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class CControllerAirport {

    @Autowired
    private IRepositoryAirport repositoryAirport;

    @GetMapping
    public List<CAirport> getAllAirports() {
        return repositoryAirport.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CAirport> getAirportById(@PathVariable Long id) {
        return repositoryAirport.findById(id);
    }

    @PostMapping
    public CAirport createAirport(@RequestBody CAirport airport) {
        return repositoryAirport.save(airport);
    }

    @PutMapping("/{id}")
    public CAirport updateAirport(@PathVariable Long id, @RequestBody CAirport airport) {
        airport.setId(id);
        return repositoryAirport.save(airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        repositoryAirport.deleteById(id);
    }
}