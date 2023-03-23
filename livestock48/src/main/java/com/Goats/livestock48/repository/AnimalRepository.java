package com.Goats.livestock48.repository;

import com.Goats.livestock48.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    /*
    @Query("SELECT A " +
            "FROM Animal A " +
            "LEFT JOIN PurchaseElement PE ON A.animalId = PE.animal.animalId " +
            "LEFT JOIN Purchase P ON P.purchaseId = PE.purchase.purchaseId " +
            "WHERE A.animalId = PE.animal.animalId " +
            "   and PE.purchase.purchaseId = P.purchaseId  " +
            "   and not (A.animalId = PE.animal.animalId and current_date() < P.purchaseDate) " +
            "   and not A.customer.customerId = ?1")
    List<Animal> getAllAvailableAnimals(Long customerID);

     */
}
