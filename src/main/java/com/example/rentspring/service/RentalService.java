package com.example.rentspring.service;

import com.example.rentspring.entities.Rental;
import com.example.rentspring.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // Получение списка аренд по tenantId
    public List<Rental> getRentalsByTenantId(int tenantId) {
        return rentalRepository.findByTenantId(tenantId);
    }

    public void updateRatingsByRentalId(int rentalId, int tenantRating, int landlordRating) {
        // Ищем запись аренды по ID
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found with id: " + rentalId));

        // Обновляем рейтинги
        rental.setTenantRating(tenantRating);
        rental.setLandlordRating(landlordRating);

        // Сохраняем изменения
        rentalRepository.save(rental);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

}
