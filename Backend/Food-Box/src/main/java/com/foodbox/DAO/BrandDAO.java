
//package com.kitchenstory.DAO;
//
//import com.kitchenstory.model.Brand;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class BrandDAO extends AbstractDAO<Brand> {
//
//    protected BrandDAO(JdbcTemplate jdbcTemplate) {
//        super(jdbcTemplate);
//    }
//
//    @Override
//    public List<Brand> getAll() {
//        return null;
//    }
//
//    @Override
//    public Brand getOneById(int id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM brand WHERE id = ?", (rs, rowNum) -> {
//            Brand brand = new Brand();
//            brand.setId(rs.getInt(1));
//            brand.setName(rs.getString(2));
//            return brand;
//        }, id);
//    }
//
//    @Override
//    public Brand add(Brand brand) {
//        return null;
//    }
//}
