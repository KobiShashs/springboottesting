package com.jb.springboottesting.controller;

import com.jb.springboottesting.beans.Cat;
import com.jb.springboottesting.exceptions.CatSystemException;
import com.jb.springboottesting.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kobis on 26 Jan, 2023
 */
@RestController
@RequestMapping("api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }


    @GetMapping("/{catId}")
    public Cat getSingletCat(@PathVariable int catId) throws CatSystemException {
        return catService.getSingleCat(catId);
    }

    @SneakyThrows
    @PostMapping(/*consumes = MediaType.APPLICATION_JSON_VALUE*/)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCat(@RequestBody Cat cat)  {
        catService.addCat(cat);
    }

    @DeleteMapping("/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable int catId) throws CatSystemException {
        catService.deleteCat(catId);
        catService.deleteCat(catId);
        catService.deleteCat(catId);
    }

    @PutMapping("/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCat(@PathVariable int catId,@RequestBody Cat cat) throws CatSystemException {
        catService.updateCat(catId, cat);
    }
}
