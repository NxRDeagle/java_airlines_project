package com.example.airlines.repositories;

import com.example.airlines.model.CAirport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryAirport extends JpaRepository<CAirport, Long> {
}
