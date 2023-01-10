package com.ironhack.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name= "name")
public class GuestUser extends User{
    private LocalDate dateOfBirth;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @OneToMany(mappedBy = "guestUser")
    private List<House> houses;
    public GuestUser() {
    }

    public GuestUser(String name, String password, String role, LocalDate dateOfBirth, Address address, UserStatus userStatus) {
        super(name, password, role);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.userStatus = userStatus;
    }
    //optional Address
    public GuestUser(String name, String password, String role, LocalDate dateOfBirth, UserStatus userStatus) {
        super(name, password, role);
        this.dateOfBirth = dateOfBirth;
        this.userStatus = userStatus;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", userStatus=" + userStatus +
                ", houses=" + houses +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
