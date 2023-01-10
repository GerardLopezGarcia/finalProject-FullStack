package com.ironhack.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HouseDTO {
    @NotNull(message = "la cantidad no puede ser nula")
    @Min(value = 0, message = "El valor no puede ser negativo")
    private Integer price;
    @NotNull(message = "la cantidad no puede ser nula")
    @Min(value = 0, message = "El valor no puede ser negativo")
    @Max(value = 5, message = "El valor no puede ser superior a 5")
    private Double score;

    public HouseDTO() {
    }
    public HouseDTO(Integer price, Double score) {
        this.price = price;
        this.score = score;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
