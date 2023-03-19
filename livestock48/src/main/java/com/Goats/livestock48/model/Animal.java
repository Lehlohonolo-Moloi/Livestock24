package com.Goats.livestock48.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    private Long animalId;
    private Double weightInKG;
    private LocalDate dob;
    @ManyToOne
    private User user;
    @ManyToOne
    private AnimalType animalType;
}
