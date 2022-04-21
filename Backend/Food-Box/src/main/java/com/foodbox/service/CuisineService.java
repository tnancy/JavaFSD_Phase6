package com.foodbox.service;

import com.foodbox.DAO.CuisineDAO;
import com.foodbox.model.Cuisine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuisineService {

    @Autowired
    private final CuisineDAO cuisneDAO;

    public CuisineService(CuisineDAO cuisneDAO) {
        this.cuisneDAO = cuisneDAO;
    }

    public Cuisine getCuisineById(int id) {
        return this.cuisneDAO.getOneById(id);
    }
}