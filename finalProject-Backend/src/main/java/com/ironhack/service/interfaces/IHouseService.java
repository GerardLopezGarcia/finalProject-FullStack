package com.ironhack.service.interfaces;

import com.ironhack.controller.dto.HouseDTO;
import com.ironhack.model.House;

import java.util.List;

public interface IHouseService {
    void deleteHouse(Integer id);
    List<House> getAllHousesByTag(String tag);
    void updateHouseDetails(HouseDTO houseDTO, Integer id);

}
