package com.foodbox.service;

import com.foodbox.DAO.DAO;
import com.foodbox.DAO.ProductDAO;
import com.foodbox.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final DAO<Product> productDAO;

    public ProductService(@Autowired ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAll() {
        return productDAO.getAll();
    }
    
    public Product add(Product product) {
        return productDAO.add(product);
    }

    public void deleteProduct(int id) {
        ((ProductDAO) this.productDAO).deleteProduct(id);
    }
}
