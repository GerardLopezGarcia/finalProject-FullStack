package com.ironhack.service.impl;

import com.ironhack.controller.dto.HouseDTO;
import com.ironhack.model.GuestUser;
import com.ironhack.model.House;
import com.ironhack.model.Status;
import com.ironhack.repository.GuestUserRepository;
import com.ironhack.repository.HouseRepository;
import com.ironhack.service.interfaces.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService implements IHouseService {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    GuestUserRepository guestUserRepository;
    public void deleteHouse(Integer id) {
        Optional<House> optionalHouse = houseRepository.findById(id);
        if(optionalHouse.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se ha encontrado el elemento con id: "+ id);
        houseRepository.deleteById(id);
    }

    public List<House> getAllHousesByTag(String tag) {
        List<House> houseList = houseRepository.findByTagsTag(tag);
        if (houseList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe ningún elemento con este tag");
        System.out.println(houseList);
        return houseList;

    }

    public void updateHouseDetails(HouseDTO houseDTO, Integer id) {
        Optional<House> optionalHouse = houseRepository.findById(id);
        if(optionalHouse.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe ningún elemento con este id");
        House house = optionalHouse.get();
        house.setPrice(houseDTO.getPrice());
        house.setScore(houseDTO.getScore());
        houseRepository.save(house);
    }

    //la gestión de reservas se hace desde un microservicio



}
