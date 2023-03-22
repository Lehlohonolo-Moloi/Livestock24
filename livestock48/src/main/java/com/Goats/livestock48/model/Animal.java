package com.Goats.livestock48.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Column(name = "animal_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;
    @Column(name = "weight_in_kg")
    private Double weightInKg;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "animal_type_id")
    private AnimalType animalType;
    @JsonIgnore
    @OneToOne(mappedBy = "animal")
    private PurchaseElement purchaseElement;
}
