package com.Goats.livestock48.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Column(name = "customer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<Animal> animals;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<Purchase> purchases;
}
