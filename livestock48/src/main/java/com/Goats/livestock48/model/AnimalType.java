package com.Goats.livestock48.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalType {

    @Id
    private Long animalTypeId;
    private String animal;
    private Double costPerKG;
}
