package com.example.airlines.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Класс самолетов
@Setter
@Getter
@Entity(name = "airplanes")
public class CAirplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    // Конструктор без параметров
    public CAirplane() {
        this.model = "";
        this.capacity = 0;
        this.manufacturer = "";
        this.registrationNumber = "";
    }

    // Конструктор с параметрами
    public CAirplane(String model, Integer capacity, String manufacturer, String registrationNumber) {
        this.model = model;
        this.capacity = capacity;
        this.manufacturer = manufacturer;
        this.registrationNumber = registrationNumber;
    }
}