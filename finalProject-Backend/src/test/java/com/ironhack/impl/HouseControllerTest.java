package com.ironhack.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.model.*;
import com.ironhack.repository.HouseRepository;
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

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class HouseControllerTest {
    @Autowired
    HouseRepository houseRepository;

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
    void getAllHouses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/houses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("5"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Saint-Victor-la-Coste"));

    }
    @Test
    void getAllHousesByTag() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/housesbytag/Popular"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("2"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Bellver"));

    }
    @Test
    void getAllHousesByprice() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/housesbyprice/200"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("3"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Bolvir"));

    }
    @Test
    void getAllHousesByScore() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/housesbyscore/4"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("5"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Calpe"));

    }
    @Test
    void getAllHousesByCountry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/housesbycountry/Francia"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Saint-Victor-la-Coste"));

    }
    @Test
    void getAllHousesByAddress() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/housesbyaddress/Bellver"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Bellver"));

    }

    //POST DELETE Houses

    @Test
    void saveHouse_deleteHouse_test() throws Exception {

        LocalDate localDate = LocalDate.of(1995,12,19);
        Address primaryAddress = new Address("Barcelona","Calle Valencia","3");
        GuestUser guestUser = new GuestUser("UsuarioDeEjemplo","ironhack","USER",localDate,primaryAddress, UserStatus.ONLINE);
        HouseDetails houseDetails = new HouseDetails(2,2,2,2);
        House house = new House(null,"España","Testlandia", Status.AVALIABLE,4.0,111,"https://dismobel.es/decora/wp-content/uploads/2018/09/21-1078x516.jpg",null,null,houseDetails);

        String body = objectMapper.writeValueAsString(house);

        mockMvc.perform(post("/houses").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/houses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType((MediaType.APPLICATION_JSON)))
                .andReturn();
        //hay que cambiar el id cada vez que se hace el test id anterior : 8
        mockMvc.perform(delete("/houses/9"))
                .andExpect(status().isNoContent())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }


}
