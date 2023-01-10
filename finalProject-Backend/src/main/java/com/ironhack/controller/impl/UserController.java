package com.ironhack.controller.impl;

import com.ironhack.controller.dto.UserDTO;
import com.ironhack.controller.interfaces.IUserController;
import com.ironhack.model.Admin;
import com.ironhack.model.GuestUser;
import com.ironhack.model.User;
import com.ironhack.repository.AdminRepository;
import com.ironhack.repository.GuestUserRepository;
import com.ironhack.repository.UserRepository;
import com.ironhack.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController implements IUserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GuestUserRepository guestUserRepository;
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserService userService;

    /* Todas las rutas de usuarios se manejarán desde el controlador UserController
     los administradores serán los únicos que podrán acceder a esta información */

    //GET
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/guestusers")
    @ResponseStatus(HttpStatus.OK)
    public List<GuestUser> getAllGuestUsers(){
        return guestUserRepository.findAll();
    }

    @GetMapping("guestusers/{name}")
    @ResponseStatus(HttpStatus.OK)
    public GuestUser getGuestUserById(@PathVariable String name){
        return userService.getGuestUserById(name);
    }
    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }
    //POST
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveUsers(@RequestBody @Valid User user){
        userRepository.save(user);
    }
    @PostMapping("/guestusers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveGuestUsers(@RequestBody @Valid GuestUser guestUser){
        guestUserRepository.save(guestUser);
    }
    @PostMapping("/admins")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveAdmins(@RequestBody @Valid Admin admin){
        adminRepository.save(admin);
    }
    //DELETE
    @DeleteMapping("/guestusers/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuestUser(@PathVariable String name){
        userService.deleteGuestUser(name);
    }
    @DeleteMapping("/admins/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable String name){
        userService.deleteAdmin(name);
    }

    //PATCH para modificar el nombre y el rol del usuario
    @PatchMapping("/guestusers/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody UserDTO userDTO, @PathVariable String name){
        userService.updateUser(userDTO,name);
    }




}
