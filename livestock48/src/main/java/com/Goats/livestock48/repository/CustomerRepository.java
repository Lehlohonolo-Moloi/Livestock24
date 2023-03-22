package com.Goats.livestock48.repository;

import com.Goats.livestock48.model.Animal;
import com.Goats.livestock48.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value="select * from Customer e where e.first_name like %:keyword%  or e.last_name like %:keyword%", nativeQuery=true)
    List<Customer> findByKeyword(@Param("keyword") String keyword);
}
