package com.example.londonapi.controller;

import com.example.londonapi.gateway.IUsersFromExternal;
import com.example.londonapi.gateway.UsersFromExternal;
import com.example.londonapi.service.IUserService;
import com.example.londonapi.service.UserService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
    Gson gson = new Gson();
    private MockMvc mockMvc;

    @InjectMocks
    private IUsersFromExternal usersFromExternal = new UsersFromExternal();
    private IUserService userService = new UserService(usersFromExternal);
    private UserController userController = new UserController(userService);

    @org.junit.Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }


    //Test people either listed as living in London or 50 Miles within London.
    @org.junit.Test
    public void allLondonTestSize() throws Exception {
        mockMvc.perform(get("/api/london")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(9)));
    }

    @org.junit.Test
    public void allLondonTestJson() throws Exception {
        MvcResult result =  mockMvc.perform(get("/api/london")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actual = gson.toJson(userController.AllLondon());

        assertEquals(result.getResponse().getContentAsString(), actual);
    }


    // Test people listed as living in London.
    @org.junit.Test
    public void livingInLondonTestSize() throws Exception {
        mockMvc.perform(get("/api/listed")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(6)));
    }
    @org.junit.Test
    public void livingInLondonTestJson() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/listed")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actual = gson.toJson(userController.LivingInLondon());

        assertEquals(result.getResponse().getContentAsString(), actual);
    }


    //People within 50 miles of London
    @org.junit.Test
    public void living50LondonTestSize() throws Exception {
        mockMvc.perform(get("/api/50miles")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }

    @org.junit.Test
    public void living50LondonTestJson() throws Exception {
        MvcResult result =  mockMvc.perform(get("/api/50miles")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actual = gson.toJson(userController.Living50London());
        assertEquals(result.getResponse().getContentAsString(), actual);
    }

}