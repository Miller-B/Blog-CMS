/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class CategoryDaoImplementation implements CategoryDaoInterface {
    
    private static String SQL_INSERT_CATEGORY = "INSERT INTO Categories (categoryName) VALUES (?)";
    private static String SQL_SELECT_CATEGORY = "SELECT * FROM Categories WHERE categoryId = ?";
    private static String SQL_UPDATE_CATEGORY = "UPDATE Categories SET categoryName = ? WHERE categoryId = ?";
    private static String SQL_DELETE_CATEGORY = "DELETE FROM Categories WHERE categoryId = ?";
    private static String SQL_FIND_ALL_CATEGORIES = "SELECT * FROM Categories LIMIT ? OFFSET ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
            category.getCategoryName()); 
        int categoryId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        category.setCategoryId(categoryId);
        return category;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new CategoryMapper(), categoryId);
        }   catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Category> findAllCategories(int limit, int offset) {
         return jdbcTemplate.query(SQL_FIND_ALL_CATEGORIES, new CategoryMapper(), limit, offset);
    }

    @Override
    public Category updateCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
            category.getCategoryName(),
            category.getCategoryId());
        return category;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    private static final class CategoryMapper implements RowMapper<Category> {
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryId(rs.getInt("categoryId")); 
            category.setCategoryName(rs.getString("categoryName")); 
        return category; 
        }
    }
    
}
