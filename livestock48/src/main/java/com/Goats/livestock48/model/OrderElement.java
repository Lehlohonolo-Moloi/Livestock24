package com.Goats.livestock48.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderElement {

    @Id
    private Long id;
    @OneToOne
    private Animal animal;
    @ManyToOne
    private Order order;
}
