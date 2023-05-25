package com.globallogic.irribarra.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Unit test for {@code SignUpController} class
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 24, 2023
 */
// @WebMvcTest(SignUpController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SignUpControllerTest {

    private final String OK_USER1 = "{\"email\":\"me@here.com\",\"password\":\"myPassword12\"}";
    private final String OK_USER2 = "{\"name\":\"Manuel Irribarra\",\"email\":\"me@here.com\",\"password\":\"myPassword12\"}";
    private final String OK_USER3 = "{\"name\":\"Manuel Irribarra\",\"email\":\"me@here.com\",\"password\":\"myPassword12\",\"phones\":[{\"number\":555100100,\"citycode\":5,\"contrycode\":\"1\"}]}";
    private final String BAD_USER1 = "{\"password\":\"myPassword12\"}";
    private final String BAD_USER2 = "{\"email\":\"me@here.com\"}";
    private final String BAD_USER3 = "{\"email\":\"noEmailHere\",\"password\":\"myPassword12\"}";
    private final String BAD_USER4 = "{\"email\":\"me@here.com\",\"password\":\"myPassword12aa\"}";
    private final String BAD_USER5 = "{\"email\":\"me@here.com\",\"password\":\"mypassword12\"}";


    @Autowired
    private MockMvc mvc;

    @Test
    public void addUserMinimumInfoTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(OK_USER1)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void addUserNameInfoTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(OK_USER2)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void addUserFullInfoTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(OK_USER3)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void badUserMissEmailTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(BAD_USER1)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists());
    }

    @Test
    public void badUserMissPasswordTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(BAD_USER2)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists());
    }

    @Test
    public void badUserEmailFormatTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(BAD_USER3)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists());
    }

    @Test
    public void badUserPasswordLengthTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(BAD_USER4)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists());
    }

    @Test
    public void badUserPasswordFormatTest() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders.post("/sign-up")
            .content(BAD_USER5)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists());
    }

}
