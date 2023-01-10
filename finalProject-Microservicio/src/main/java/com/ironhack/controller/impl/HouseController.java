package com.ironhack.controller.impl;


import com.ironhack.controller.interfaces.IHouseController;
import com.ironhack.repository.HouseRepository;
import com.ironhack.service.impl.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class HouseController implements IHouseController {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    HouseService houseService;

    // microservicio
    //reservar casa
    @PatchMapping("houses/{id}/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignGuestToHouse(@PathVariable Integer id,@PathVariable String name){
        houseService.assignGuestToHouse(id,name);
    }
    //eliminar reserva
    @PatchMapping("houseunassignguest/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unAssignGuestToHouse(@PathVariable Integer id){
        houseService.unAssignGuestToHouse(id);
    }
}
