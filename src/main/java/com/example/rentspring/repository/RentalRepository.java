package com.example.rentspring.repository;

import com.example.rentspring.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // Найти аренды по идентификатору арендатора
    List<Rental> findByTenantId(int tenantId);

}