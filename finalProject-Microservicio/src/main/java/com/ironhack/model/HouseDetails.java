package com.ironhack.model;

import javax.persistence.Embeddable;

@Embeddable
public class HouseDetails {
    private Integer bedrooms;
    private Integer beds;
    private Integer bathrooms;
    private Integer guests;
    public HouseDetails() {
        this.bathrooms = 1;
        this.bedrooms = 1;
        this.beds = 2;
        this.guests = 2;
    }

    public HouseDetails(Integer bedrooms, Integer beds, Integer bathrooms, Integer guests) {
        this.bedrooms = bedrooms;
        this.beds = beds;
        this.bathrooms = bathrooms;
        this.guests = guests;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "HouseDetails{" +
                "bedrooms=" + bedrooms +
                ", beds=" + beds +
                ", bathrooms=" + bathrooms +
                ", guests=" + guests +
                '}';
    }
}
