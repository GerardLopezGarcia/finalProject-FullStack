package com.ironhack.controller.impl;

import com.ironhack.controller.dto.HouseDTO;
import com.ironhack.controller.interfaces.IHouseController;
import com.ironhack.model.House;
import com.ironhack.repository.HouseRepository;
import com.ironhack.service.impl.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HouseController implements IHouseController {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    HouseService houseService;

    //GET
    @GetMapping("/houses")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }

    @GetMapping("/houses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public House getHouseById(@PathVariable int id){
        return houseRepository.findById(id).get();
    }
    //------filtrar por tags
    @GetMapping("/housesbytag/{tag}")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHousesByTag(@PathVariable String tag){
        return houseService.getAllHousesByTag(tag);
    }

    //------filtrar por precio
    @GetMapping("housesbyprice/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHousesByPrice(@PathVariable Integer price){
        return houseRepository.findByPriceLessThanEqual(price);
    }
    //------filtrar por puntuación
    @GetMapping("housesbyscore/{score}")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHousesByScore(@PathVariable Double score){
        return houseRepository.findByScoreGreaterThanEqual(score);
    }
    //------filtrar por usuario
    @GetMapping("housesbyguest/{guest_user}")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHousesByGuests(@PathVariable String guests){
        return houseRepository.findByGuestUser(guests);
    }
    //------filtrar por país
    @GetMapping("housesbycountry/{country}")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHousesByCountry(@PathVariable String country){
        return houseRepository.findByCountry(country);
    }
    //------filtrar por localización
    @GetMapping("housesbyaddress/{houseAddress}")
    @ResponseStatus(HttpStatus.OK)
    public List<House> getAllHousesByHouseAddress(@PathVariable String houseAddress){
        return houseRepository.findByHouseAddress(houseAddress);
    }

    //POST
    @PostMapping("/houses")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveHouses(@RequestBody @Valid House house){
        houseRepository.save(house);
    }
    //DELETE
    @DeleteMapping("/houses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHouse(@PathVariable Integer id){
        houseService.deleteHouse(id);
    }

    //PATCH para modificar características del housing
    //Solo precio y puntuación
    @PatchMapping("/houses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHouseDetails(@RequestBody HouseDTO houseDTO, @PathVariable Integer id){
        houseService.updateHouseDetails(houseDTO,id);
    }

}
