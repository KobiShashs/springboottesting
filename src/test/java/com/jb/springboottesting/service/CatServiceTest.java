package com.jb.springboottesting.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.springboottesting.beans.Cat;
import com.jb.springboottesting.core.BaseTesting;
import com.jb.springboottesting.repos.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Created by kobis on 26 Jan, 2023
 */
@ExtendWith(MockitoExtension.class)
class CatServiceTest extends BaseTesting {

//    @Autowired
//    protected ObjectMapper objectMapper;

    @InjectMocks
    private CatServiceImpl catService;

    @Mock
    private CatRepository catRepository;



    @Test
    void getAllCats() throws JsonProcessingException {

        when(catRepository.findAll()).thenReturn(this.catList);
        List<Cat> cats = catService.getAllCats();
        assertEquals(2,cats.size());
        String expected = cats.toString();
        String actual = this.catList.toString();
        assertEquals(expected,actual);
    }

    @Test
    void getSingleCat() {
    }

    @Test
    void deleteCat() {
    }

    @Test
    void addCat() {
    }

    @Test
    void updateCat() {
    }
}