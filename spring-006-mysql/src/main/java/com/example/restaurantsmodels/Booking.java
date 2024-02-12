package com.example.restaurantsmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table (name = "booking")
public class Booking {
    @Id
    private long id;

    private LocalDateTime date;

    private Integer numUsers;

    private String observations;

    private String status;

    private User user;

    private Restaurant restaurant;

    private Boolean interior;

    private Integer numTable;
}
