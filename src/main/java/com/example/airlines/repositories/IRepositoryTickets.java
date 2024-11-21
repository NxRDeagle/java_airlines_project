package com.example.airlines.repositories;

import com.example.airlines.model.CTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryTickets extends JpaRepository<CTickets, Long> {

}