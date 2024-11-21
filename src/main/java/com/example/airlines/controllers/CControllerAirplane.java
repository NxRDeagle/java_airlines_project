package com.example.airlines.controllers;

import com.example.airlines.model.CAirplane;
import com.example.airlines.repositories.IRepositoryAirplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airplanes")
public class CControllerAirplane {

    @Autowired
    private IRepositoryAirplane repositoryAirplane;

    @GetMapping
    public List<CAirplane> getAllAirplanes() {
        return repositoryAirplane.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CAirplane> getAirplaneById(@PathVariable Long id) {
        return repositoryAirplane.findById(id);
    }

    @PostMapping
    public CAirplane createAirplane(@RequestBody CAirplane airplane) {
        return repositoryAirplane.save(airplane);
    }

    @PutMapping("/{id}")
    public CAirplane updateAirplane(@PathVariable Long id, @RequestBody CAirplane airplane) {
        airplane.setId(id);
        return repositoryAirplane.save(airplane);
    }

    @DeleteMapping("/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        repositoryAirplane.deleteById(id);
    }

}
