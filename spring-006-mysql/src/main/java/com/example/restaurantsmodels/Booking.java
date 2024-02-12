package com.example.restaurantsmodels;

import jakarta.persistence.*;
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
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   // private User user;

    private LocalDateTime date;

    private Integer numUsers;

    private String observations;

    private String status;

    //private Restaurant restaurant;

    private Boolean interior;

    private Integer numTable;
}
