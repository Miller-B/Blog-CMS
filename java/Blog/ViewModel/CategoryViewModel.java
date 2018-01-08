/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ViewModel;

import Blog.Dto.Category;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class CategoryViewModel {
    
    private Category selectedCategory;
    
    private List<Category> categories;

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    
        
}
