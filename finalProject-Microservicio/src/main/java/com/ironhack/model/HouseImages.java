package com.ironhack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="url")
public class HouseImages {
    @Id
    private String url;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="house_id")
    private House house;

    public HouseImages(String url, House house) {
        this.url = url;
        this.house = house;
    }

    public HouseImages() {
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
