package com.ironhack.service.interfaces;

import com.ironhack.model.House;

import java.util.List;

public interface IHouseService {

    void assignGuestToHouse(Integer id, String name);

    void unAssignGuestToHouse(Integer id);
}
