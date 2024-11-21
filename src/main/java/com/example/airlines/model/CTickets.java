package com.example.airlines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

// Класс авиабилетов
@Setter
@Getter
@Entity(name = "tickets")
public class CTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", nullable = true, length = 50)
    private String middleName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "company", nullable = false, length = 100)
    private String company;

    @Column(name = "airplane", nullable = true, length = 100)
    private String airplane;

    @Column(name = "airport_departure", nullable = false, length = 100)
    private String airportDeparture;

    @Column(name = "airport_arrive", nullable = false, length = 100)
    private String airportArrive;

    @Column(name = "departure_at", nullable = false)
    private LocalDateTime departureAt;

    @Column(name = "arrive_at", nullable = false)
    private LocalDateTime arriveAt;

    // Конструктор без параметров
    public CTickets() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = null;
        this.birthday = LocalDate.now();
        this.phoneNumber = "";
        this.company = "";
        this.airplane = null;
        this.airportDeparture = "";
        this.airportArrive = "";
        this.departureAt = LocalDateTime.now();
        this.arriveAt = LocalDateTime.now();
    }

    // Конструктор с параметрами
    public CTickets(String lastName, String firstName, String middleName, LocalDate birthday, String phoneNumber,
                    String company, String airplane, String airportDeparture, String airportArrive,
                    LocalDateTime departureAt, LocalDateTime arriveAt) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.setPhoneNumber(phoneNumber); // Используем сеттер для проверки формата
        this.company = company;
        this.airplane = airplane;
        this.airportDeparture = airportDeparture;
        this.airportArrive = airportArrive;
        this.departureAt = departureAt;
        this.arriveAt = arriveAt;
    }

    // Сеттер для phoneNumber с проверкой формата
    public void setPhoneNumber(String phoneNumber) {
        // формат номера телефона +7**********
        if (Pattern.matches("\\+\\d{11}", phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}