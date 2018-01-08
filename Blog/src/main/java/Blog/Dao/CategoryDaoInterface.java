/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Category;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface CategoryDaoInterface {
    
    public Category createCategory(Category category);
    
    public Category getCategoryById(Integer categoryId);
    
    public List<Category> findAllCategories(int limit, int offset);
    
    public Category updateCategory(Category category);
    
    public void deleteCategory(Integer categoryId);
    
}
