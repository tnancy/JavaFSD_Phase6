package com.foodbox.DAO;

import com.foodbox.model.Product;
import com.foodbox.model.User;
import com.foodbox.service.CategoryService;
import com.foodbox.service.CuisineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO extends AbstractDAO<Product> {
    private final CategoryService categoryService;
    private final CuisineService cuisineService;

    protected ProductDAO(JdbcTemplate jdbcTemplate, @Autowired CategoryService categoryService, @Autowired CuisineService cuisineService) {
        super(jdbcTemplate);
        this.categoryService = categoryService;
        this.cuisineService = cuisineService;
    }
	
    @Override
    public List<Product> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM product", (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setCategory(categoryService.getCategoryById(rs.getInt(3)).toString());
            product.setPrice(rs.getInt(4));
            product.setCuisine(cuisineService.getCuisineById(rs.getInt(5)).toString());
            product.setImg(rs.getString(6));
            return product;
        });
    }
    
    @Override
    public Product getOneById(int id) {
        return null;
    }

    @Override
    public Product add(Product product) throws DuplicateKeyException {
        this.jdbcTemplate.update("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?)",
                product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getCuisine(), product.getImg());
        return product;
    }

    public void deleteProduct(int id) {
        this.jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }
}
