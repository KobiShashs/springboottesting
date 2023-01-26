package com.jb.springboottesting.service;

import com.jb.springboottesting.beans.Cat;
import com.jb.springboottesting.exceptions.CatSystemException;

import java.util.List;

/**
 * Created by kobis on 26 Jan, 2023
 */
public interface CatService {

    List<Cat> getAllCats();

    Cat getSingleCat(long catId) throws CatSystemException;

    void deleteCat(long catId) throws CatSystemException;

    void addCat(Cat cat) throws CatSystemException;

    void updateCat(long catId, Cat cat) throws CatSystemException;
}
