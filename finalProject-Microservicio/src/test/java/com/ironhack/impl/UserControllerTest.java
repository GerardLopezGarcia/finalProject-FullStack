package com.ironhack.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.controller.dto.UserDTO;
import com.ironhack.model.Address;
import com.ironhack.model.Admin;
import com.ironhack.model.GuestUser;
import com.ironhack.model.UserStatus;
import com.ironhack.repository.AdminRepository;
import com.ironhack.repository.GuestUserRepository;
import com.ironhack.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GuestUserRepository guestUserRepository;
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper.registerModule(new JavaTimeModule());

    }

    //GET
    @Test
    void getAllUsers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("7"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Padres con hijos"));

    }
    @Test
    void getAllGuestUsers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/guestusers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("5"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Grupo de amigos"));

    }
    @Test
    void getGuestUserByName() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/guestusers/Mujer Ilusionada"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mujer Ilusionada"));

    }
    @Test
    void getAllAdmins() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admins"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("TrabajadorEmpedernido"));

    }


    //POST DELETE Users

    @Test
    void saveGuestUser_deleteguestUser_test() throws Exception {

        LocalDate localDate = LocalDate.of(1995,12,19);
        Address primaryAddress = new Address("Barcelona","Calle Valencia","3");
        GuestUser guestUser = new GuestUser("UsuarioDeEjemplo","ironhack","USER",localDate,primaryAddress, UserStatus.ONLINE);

        String body = objectMapper.writeValueAsString(guestUser);

        mockMvc.perform(post("/guestusers").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/guestusers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();

        mockMvc.perform(delete("/guestusers/UsuarioDeEjemplo"))
                .andExpect(status().isNoContent())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    //POST DELETE Admins

    @Test
    void saveAdmins_deleteAdmins_test() throws Exception {

        Admin admin = new Admin("AdminDeEjemplo","admin","ADMIN");
        String body = objectMapper.writeValueAsString(admin);

        mockMvc.perform(post("/admins").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/admins"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();

        mockMvc.perform(delete("/admins/AdminDeEjemplo"))
                .andExpect(status().isNoContent())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }
    //PATCH
    @Test
    void updateGuestUser() throws Exception {

        UserDTO userDTO = new UserDTO("Estudiante indeciso","USER",UserStatus.ONLINE);
        String body = objectMapper.writeValueAsString(userDTO);

        mockMvc.perform(patch("/guestusers/Estudiante indeciso").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
        //hace un get y mira si ha creado
        MvcResult mvcResult = mockMvc.perform(get("/guestusers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Estudiante"));
    }
}
