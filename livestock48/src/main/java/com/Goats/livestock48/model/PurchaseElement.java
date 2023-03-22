package com.Goats.livestock48.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseElement {
    @Column(name = "purchase_element_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseElementId;
    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

}
