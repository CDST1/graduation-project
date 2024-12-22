package com.example.rentspring.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;

    @Column(nullable = false)
    private int propertyId;

    @Column(nullable = false)
    private int tenantId;

    @Column(nullable = false)
    private int landlordId;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    private Integer tenantRating;
    private Integer landlordRating;

    public Rental() {}

    public Rental(int propertyId, int tenantId, int landlordId, Date startDate, Date endDate, Integer tenantRating, Integer landlordRating) {
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.landlordId = landlordId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantRating = tenantRating;
        this.landlordRating = landlordRating;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getTenantRating() {
        return tenantRating;
    }

    public void setTenantRating(Integer tenantRating) {
        this.tenantRating = tenantRating;
    }

    public Integer getLandlordRating() {
        return landlordRating;
    }

    public void setLandlordRating(Integer landlordRating) {
        this.landlordRating = landlordRating;
    }
}