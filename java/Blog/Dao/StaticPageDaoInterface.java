/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.StaticPage;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface StaticPageDaoInterface {
    
    public StaticPage createStaticPage(StaticPage staticPage);
    
    public StaticPage getStaticPageById(Integer staticPageId);
    
    public List<StaticPage> findAllStaticPages(int limit, int offset);
    
    public StaticPage updateStaticPage(StaticPage staticPage);
    
    public void deleteStaticPage(Integer staticPageId);
    
}
