package com.example.rentspring.service;

import com.example.rentspring.entities.Property;
import com.example.rentspring.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getPropertiesByOwnerUsername(String ownerUsername) {
        return propertyRepository.findByOwnerUsername(ownerUsername);
    }

    public Property getPropertyById(int id) {
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public void updateProperty(int id, Property updatedProperty) {
        Property property = getPropertyById(id);
        property.setTitle(updatedProperty.getTitle());
        property.setDescription(updatedProperty.getDescription());
        property.setCity(updatedProperty.getCity());
        property.setPrice(updatedProperty.getPrice());
        propertyRepository.save(property);
    }

    public List<Property> searchProperties(String city, Double minPrice, Double maxPrice, Integer rooms) {
        if (city != null && minPrice != null && maxPrice != null && rooms != null) {
            return propertyRepository.findByCityAndPriceBetweenAndRooms(city, minPrice, maxPrice, rooms);
        } else if (city != null && minPrice != null && maxPrice != null) {
            return propertyRepository.findByCityAndPriceBetween(city, minPrice, maxPrice);
        } else if (city != null && rooms != null) {
            return propertyRepository.findByCityAndRooms(city, rooms);
        } else if (city != null) {
            return propertyRepository.findByCity(city);
        } else {
            return propertyRepository.findAll();
        }
    }

    public void saveProperty(Property property) {
        propertyRepository.save(property);
    }

}

