package com.ironhack.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "name")
public class Admin extends User{
    public Admin(){}

    public Admin(String name, String password, String role) {
        super(name, password, role);
    }
}
