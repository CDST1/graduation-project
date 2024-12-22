package com.example.rentspring.repository;

import com.example.rentspring.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findByCity(String city);

    List<Property> findByCityAndPriceBetween(String city, double minPrice, double maxPrice);

    List<Property> findByCityAndRooms(String city, int rooms);

    List<Property> findByCityAndPriceBetweenAndRooms(String city, double minPrice, double maxPrice, int rooms);

    List<Property> findByOwnerUsername(String ownerUsername);
}
