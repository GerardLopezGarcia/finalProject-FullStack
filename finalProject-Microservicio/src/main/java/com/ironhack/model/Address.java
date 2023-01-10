package com.ironhack.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String houseAddress;

    public Address() {
        this.city = "Barcelona";
        this.street = "Avenida Diagonal";
        this.houseAddress = "1º 1ª";
    }

    public Address(String city, String street, String houseAddress) {
        this.city = city;
        this.street = street;
        this.houseAddress = houseAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
}
