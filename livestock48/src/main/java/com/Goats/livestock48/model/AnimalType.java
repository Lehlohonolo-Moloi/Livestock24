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
public class AnimalType {
    @Column(name = "animal_type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalTypeId;
    @Column(name = "animal_name")
    private String animalName;
    @Column(name = "animal_breed")
    private String animalBreed;
    @JsonIgnore
    @OneToMany(mappedBy = "animalType")
    private Set<Animal> animals;
}
