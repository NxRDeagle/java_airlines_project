package com.example.airlines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

// Класс аэропортов
@Setter
@Getter
@Entity(name = "airports")
public class CAirport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    // Конструктор без параметров
    public CAirport() {
        this.name = "";
        this.city = "";
        this.country = "";
    }

    // Конструктор с параметрами
    public CAirport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }
}