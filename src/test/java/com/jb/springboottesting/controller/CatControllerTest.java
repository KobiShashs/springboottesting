package com.jb.springboottesting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.springboottesting.beans.Cat;
import com.jb.springboottesting.core.BaseTesting;
import com.jb.springboottesting.service.CatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Created by kobis on 26 Jan, 2023
 */
@WebMvcTest(CatController.class)
class CatControllerTest extends BaseTesting {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Value("${api.cats}")
    private String baseUrl;



    @MockBean
    private CatService catService;

    @Test
    void getAllCats() throws Exception {

        String body = objectMapper.writeValueAsString(this.catList);
        given(catService.getAllCats()).willReturn(this.catList);

        MvcResult result = mvc.perform(get(baseUrl)).andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals(body, result.getResponse().getContentAsString());
        List<Cat> fromJson = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
        assertEquals(2, fromJson.size());

    }

    @Test
    void deleteCat() throws Exception {

        //todo - why the hall it appeared once and not 3 times!!!!
        catService.deleteCat(1);

        verify(catService, times(1)).deleteCat(1);
        MvcResult result = mvc.perform(delete(baseUrl + "/" + 1)).andReturn();
        assertEquals(204, result.getResponse().getStatus());
    }

    @Test
    void addCat() throws Exception {

        catService.addCat(this.c1);

        String body = objectMapper.writeValueAsString(this.c1);

        verify(catService, times(1)).addCat(this.c1);

        MvcResult result = mvc.perform(post(baseUrl).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(body)).andReturn();
        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void getSingletCat() throws Exception {

        String body = objectMapper.writeValueAsString(this.c1);
        given(catService.getSingleCat(1)).willReturn(this.c1);
        MvcResult result = mvc.perform(get(baseUrl + "/" + 1)).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals(body, result.getResponse().getContentAsString());
    }

    @Test
    void updateCat() throws Exception {

        Cat toUpdate = this.c1;
        toUpdate.setName("Mitziyahoo");
        String body  = objectMapper.writeValueAsString(toUpdate);
        catService.updateCat(1,toUpdate);
        verify(catService,times(1)).updateCat(1,toUpdate);

        MvcResult result = mvc.perform(put(baseUrl+"/"+1).contentType(MediaType.APPLICATION_JSON).content(body)).andReturn();
        assertEquals(204,result.getResponse().getStatus());
    }
}