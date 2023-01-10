package com.ironhack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="tag")
public class Tags {
    @Id
    private String tag;
    @JsonIgnore
    @ManyToMany
    private List<House> house;

    public Tags() {
    }

    public Tags(String tag, List<House> house) {
        this.tag = tag;
        this.house = house;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<House> getHouse() {
        return house;
    }

    public void setHouse(List<House> house) {
        this.house = house;
    }
}
