/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ViewModel;

import Blog.Dto.Category;
import Blog.Dto.StaticPage;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class StaticPageViewModel {
    
    private StaticPage selectedStaticPage;
    
    private List<StaticPage> staticPages;
    
    private List<Category> categories;

    public StaticPage getSelectedStaticPage() {
        return selectedStaticPage;
    }

    public void setSelectedStaticPage(StaticPage selectedStaticPage) {
        this.selectedStaticPage = selectedStaticPage;
    }

    public List<StaticPage> getStaticPages() {
        return staticPages;
    }

    public void setStaticPages(List<StaticPage> staticPages) {
        this.staticPages = staticPages;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    
    
}
