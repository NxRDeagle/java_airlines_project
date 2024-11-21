package com.example.airlines.repositories;

import com.example.airlines.model.CAirplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryAirplane extends JpaRepository<CAirplane, Long> {
}
