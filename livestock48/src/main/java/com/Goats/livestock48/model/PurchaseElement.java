package com.Goats.livestock48.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseElementId;
    @OneToOne
    private Animal animal;
    @ManyToOne
    private Purchase purchase;
}
