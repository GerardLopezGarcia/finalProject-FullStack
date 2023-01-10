package com.ironhack.service.impl;

import com.ironhack.controller.dto.UserDTO;
import com.ironhack.model.Admin;
import com.ironhack.model.GuestUser;
import com.ironhack.model.User;
import com.ironhack.repository.AdminRepository;
import com.ironhack.repository.GuestUserRepository;
import com.ironhack.repository.UserRepository;
import com.ironhack.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    GuestUserRepository guestUserRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRepository userRepository;
    public void deleteGuestUser(String name) {
        Optional<GuestUser> optionalGuestUser = guestUserRepository.findById(name);
        if(optionalGuestUser.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la cuenta asociada a este nombre");
        guestUserRepository.deleteById(name);
    }
    public void deleteAdmin(String name) {
        Optional<Admin> optionalAdmin = adminRepository.findById(name);
        if(optionalAdmin.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha encontrado la cuenta asociada a este nombre");
    }

    public void updateUser(UserDTO userDTO, String name) {
        Optional<User> optionalUser = userRepository.findById(name);
        if(optionalUser.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha encontrado la cuenta asociada a este id");
        User user = optionalUser.get();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        userRepository.save(user);
    }

    public GuestUser getGuestUserById(String name) {
        Optional<GuestUser> optionalGuestUser = guestUserRepository.findById(name);
        if(optionalGuestUser.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha encontrado la cuenta asociad a este id");
        return optionalGuestUser.get();
    }
}
