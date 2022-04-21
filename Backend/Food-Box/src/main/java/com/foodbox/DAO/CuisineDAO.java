package com.foodbox.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Cuisine;

import java.util.List;

@Repository
public class CuisineDAO extends AbstractDAO<Cuisine> {

    protected CuisineDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Cuisine> getAll() {
        return null;
    }

    @Override
    public Cuisine getOneById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cuisine WHERE id = ?", (rs, rowNum) -> {
        	Cuisine cuisine = new Cuisine();
            cuisine.setId(rs.getInt(1));
            cuisine.setName(rs.getString(2));
            return cuisine;
        }, id);
    }
    
    
    @Override
    public Cuisine add(Cuisine cuisne) {
        return null;
    }
}
