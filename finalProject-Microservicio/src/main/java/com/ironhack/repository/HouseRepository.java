package com.ironhack.repository;

import com.ironhack.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository <House,Integer> {
    List<House> findByTagsTag(String tag);
    List<House> findByPriceLessThanEqual(int price);

    List<House> findByScoreGreaterThanEqual(Double score);
    List<House> findByGuestUser(String guests);
    List<House> findByCountry(String country);
    List<House> findByHouseAddress(String houseAddress);

}
