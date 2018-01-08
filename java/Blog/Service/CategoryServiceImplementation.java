/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.CategoryCommandModel;
import Blog.Dao.CategoryDaoInterface;
import Blog.Dto.Category;
import Blog.ViewModel.CategoryViewModel;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jeffc
 */
public class CategoryServiceImplementation implements CategoryServiceInterface {
    
    
    private CategoryDaoInterface categoryDao;
    
    public CategoryServiceImplementation(CategoryDaoInterface categoryDao) {
        this.categoryDao = categoryDao;
    }    

    @Override
    public Category createCategory(Category category) {
        return categoryDao.createCategory(category);
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryDao.deleteCategory(categoryId);
    }

    @Override
    public List<Category> findAllCategories(int limit, int offset) {
        return categoryDao.findAllCategories(limit, offset);
    }
    
    @Override
    public CategoryViewModel buildCategoryViewModelFromCategory(Category category) {

        CategoryViewModel cvm = new CategoryViewModel();
        cvm.setSelectedCategory(category);
        cvm.setCategories(this.findAllCategories(Integer.MAX_VALUE, 0));
        return cvm;

    }

    @Override
    public Category buildCategoryFromCategoryCommandModel(CategoryCommandModel ccm) {

        Category category = new Category();
        if (ccm.getCategoryId() != null) {
            category.setCategoryId(ccm.getCategoryId());
        }
        category.setCategoryName(ccm.getCategoryName());
        return category;
    }    
    
}