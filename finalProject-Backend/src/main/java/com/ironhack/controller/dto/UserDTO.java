package com.ironhack.controller.dto;

import com.ironhack.model.UserStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserDTO {
    private String name;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String name, String role, UserStatus userStatus) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
