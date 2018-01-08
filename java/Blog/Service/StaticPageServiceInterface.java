/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.StaticPageCommandModel;
import Blog.Dto.StaticPage;
import Blog.ViewModel.StaticPageViewModel;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface StaticPageServiceInterface {
    
    public StaticPage createStaticPage(StaticPage staticPage);
    
    public StaticPage getStaticPageById(Integer staticPageId);
    
    public StaticPage updateStaticPage(StaticPage staticPage);
    
    public void deleteStaticPage(Integer staticPageId);
    
    public List<StaticPage> findAllStaticPages(int limit, int offset);
    
public StaticPageViewModel buildStaticPageViewModelFromStaticPage(StaticPage staticPage);
    
    public StaticPage buildStaticPageFromStaticPageCommandModel(StaticPageCommandModel spcm);    
    
}
