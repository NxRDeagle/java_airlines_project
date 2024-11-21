package com.example.airlines.controllers;

import com.example.airlines.model.CTickets;
import com.example.airlines.repositories.IRepositoryTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class CControllerTickets {

    @Autowired
    private IRepositoryTickets repositoryTickets;

    @GetMapping
    public List<CTickets> getAllTickets() {
        return repositoryTickets.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CTickets> getTicketById(@PathVariable Long id) {
        return repositoryTickets.findById(id);
    }

    @PostMapping
    public CTickets createTicket(@RequestBody CTickets ticket) {
        return repositoryTickets.save(ticket);
    }

    @PutMapping("/{id}")
    public CTickets updateTicket(@PathVariable Long id, @RequestBody CTickets ticket) {
        ticket.setId(id);
        return repositoryTickets.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        repositoryTickets.deleteById(id);
    }
}