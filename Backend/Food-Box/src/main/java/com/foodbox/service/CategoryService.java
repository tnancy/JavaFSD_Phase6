package com.foodbox.service;

import com.foodbox.DAO.DAO;
import com.foodbox.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final DAO<Category> categoryDAO;

    public CategoryService(@Autowired DAO<Category> categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getOneById(id);
    }

}
