package com.bitebooking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Double salary;

    @ManyToOne
    private Company company;

    @ManyToMany
    @ToString.Exclude
    private List<Project> projects = new ArrayList<>();


}
