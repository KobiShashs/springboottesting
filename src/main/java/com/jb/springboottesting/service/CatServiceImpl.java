package com.jb.springboottesting.service;

import com.jb.springboottesting.beans.Cat;
import com.jb.springboottesting.exceptions.CatSystemException;
import com.jb.springboottesting.exceptions.ErrMsg;
import com.jb.springboottesting.exceptions.ErrUtils;
import com.jb.springboottesting.repos.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kobis on 26 Jan, 2023
 */
@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getSingleCat(long catId) throws CatSystemException {

        return catRepository.findById(catId)
                .orElseThrow(ErrUtils::notFound);
    }

    @Override
    public void deleteCat(long catId) throws CatSystemException {
        if (!catRepository.existsById(catId)) {
            throw new CatSystemException(ErrMsg.CAT_ID_NOT_FOUND);
        }
        catRepository.deleteById(catId);
    }

    @Override
    public void addCat(Cat cat) throws CatSystemException {
        long id = cat.getId();
        if (catRepository.existsById(id)) {
            throw new CatSystemException(ErrMsg.CAT_ID_ALREADY_EXIST);
        }
        catRepository.save(cat);
    }

    @Override
    public void updateCat(long catId, Cat cat) throws CatSystemException {
        if (!catRepository.existsById(catId)) {
            throw new CatSystemException(ErrMsg.CAT_ID_NOT_FOUND);
        }

        catRepository.save(cat);
    }


}
