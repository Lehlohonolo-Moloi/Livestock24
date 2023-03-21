package com.Goats.livestock48.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;
    private Boolean status;
    private LocalDate purchaseDate;
    @ManyToOne
    private Customer customer;
//    @OneToMany
//    @JoinColumn(name = "purchase_element_id")
//    private Set<PurchaseElement> purchaseElements;
}
