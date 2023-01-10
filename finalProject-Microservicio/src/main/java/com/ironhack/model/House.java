package com.ironhack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private GuestUser guestUser;
    private String country;
    private String houseAddress;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Min(value = 0, message = "El valor no puede ser negativo")
    @Max(value = 5, message = "El valor no puede ser superior a 5")
    private Double score;
    @Min(value = 0, message = "El valor no puede ser negativo")
    private int price;
    private String imageUrl;
    @OneToMany(mappedBy = "house",cascade = CascadeType.ALL)
    private List<HouseImages> houseImages;
    @ManyToMany
    @JoinTable(
            name="tags_house"
    )
    private List<Tags> tags;
    @Embedded
    private HouseDetails houseDetails;

    public House() {
    }

    public House(GuestUser guestUser, String country, String houseAddress, Status status, Double score, int price, String imageUrl, List<HouseImages> houseImages, List<Tags> tags, HouseDetails houseDetails) {
        this.guestUser = guestUser;
        this.country = country;
        this.houseAddress = houseAddress;
        this.status = status;
        this.score = score;
        this.price = price;
        this.imageUrl = imageUrl;
        this.houseImages = houseImages;
        this.tags = tags;
        this.houseDetails = houseDetails;
    }

    public List<HouseImages> getHouseImages() {
        return houseImages;
    }

    public void setHouseImages(List<HouseImages> houseImages) {
        this.houseImages = houseImages;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GuestUser getGuestUser() {
        return guestUser;
    }

    public void setGuestUser(GuestUser guestUser) {
        this.guestUser = guestUser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public HouseDetails getHouseDetails() {
        return houseDetails;
    }

    public void setHouseDetails(HouseDetails houseDetails) {
        this.houseDetails = houseDetails;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", guestUser=" + guestUser +
                ", country='" + country + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", status=" + status +
                ", score=" + score +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", houseImages=" + houseImages +
                ", tags=" + tags +
                ", houseDetails=" + houseDetails +
                '}';
    }
}
