package com.ironhack.service.impl;

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
import java.util.Optional;

@Service
public class HouseService implements IHouseService {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    GuestUserRepository guestUserRepository;

    // microservicio
    //gestion reserva
    public void assignGuestToHouse(Integer id, String name) {
        Optional <GuestUser> optionalGuestUser = guestUserRepository.findById(name);
        Optional <House> optionalHouse = houseRepository.findById(id);
        if(optionalGuestUser.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encuentra el usuario con este nombre");
        if(optionalHouse.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encuentra el immueble con este id");
        House house = optionalHouse.get();
        if(house.getGuestUser() == null){
            GuestUser guestUser = optionalGuestUser.get();
            house.setGuestUser(guestUser);
            house.setStatus(Status.UNAVALIABLE);
            houseRepository.save(house);
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Este inmueble ya tiene una reserva");
        }


    }
    //eliminar reserva
    public void unAssignGuestToHouse(Integer id) {
        Optional <House> optionalHouse = houseRepository.findById(id);
        if(optionalHouse.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encuentra el immueble con este id");
        House house = optionalHouse.get();
        house.setGuestUser(null);
        house.setStatus(Status.AVALIABLE);
        houseRepository.save(house);
    }



}
