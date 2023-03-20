package com.Goats.livestock48.repository;

import com.Goats.livestock48.model.PurchaseElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseElementRepository extends JpaRepository<PurchaseElement, Long> {
}
