package com.ironhack.service.interfaces;

import com.ironhack.controller.dto.UserDTO;
import com.ironhack.model.GuestUser;

public interface IUserService {
    void deleteGuestUser(String name);
    void deleteAdmin(String name);

    void updateUser(UserDTO userDTO, String name);

    GuestUser getGuestUserById(String name);
}
