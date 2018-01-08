/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.CategoryCommandModel;
import Blog.Dto.Category;
import Blog.ViewModel.CategoryViewModel;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface CategoryServiceInterface {

    // Category CRUD methods
    public Category createCategory(Category category);

    public Category getCategoryById(Integer categoryId);

    public Category updateCategory(Category category);

    public void deleteCategory(Integer categoryId);

    public List<Category> findAllCategories(int limit, int offset);

    public CategoryViewModel buildCategoryViewModelFromCategory(Category category);

    public Category buildCategoryFromCategoryCommandModel(CategoryCommandModel ccm);

}
