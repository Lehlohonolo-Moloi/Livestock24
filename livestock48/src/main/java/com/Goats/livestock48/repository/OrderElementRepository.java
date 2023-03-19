package com.Goats.livestock48.repository;

import com.Goats.livestock48.model.OrderElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderElementRepository extends JpaRepository<OrderElement, Long> {
}
