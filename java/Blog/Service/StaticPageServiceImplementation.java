/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.StaticPageCommandModel;
import Blog.Dao.CategoryDaoInterface;
import Blog.Dao.StaticPageDaoInterface;
import Blog.Dto.StaticPage;
import Blog.ViewModel.StaticPageViewModel;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class StaticPageServiceImplementation implements StaticPageServiceInterface {

    private StaticPageDaoInterface staticPageDao;

    private CategoryServiceInterface categoryService;

    public StaticPageServiceImplementation(StaticPageDaoInterface staticPageDao) {
        this.staticPageDao = staticPageDao;
    }
    
    public void setCategoryService(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }    

    @Override
    public StaticPage createStaticPage(StaticPage staticPage) {
        return staticPageDao.createStaticPage(staticPage);
    }

    @Override
    public StaticPage getStaticPageById(Integer staticPageId) {
        return staticPageDao.getStaticPageById(staticPageId);
    }

    @Override
    public StaticPage updateStaticPage(StaticPage staticPage) {
        return staticPageDao.updateStaticPage(staticPage);
    }

    @Override
    public void deleteStaticPage(Integer staticPageId) {
        staticPageDao.deleteStaticPage(staticPageId);
    }

    @Override
    public List<StaticPage> findAllStaticPages(int limit, int offset) {
        return staticPageDao.findAllStaticPages(limit, offset);
    }

    @Override
    public StaticPageViewModel buildStaticPageViewModelFromStaticPage(StaticPage staticPage) {

        StaticPageViewModel spvm = new StaticPageViewModel();
        spvm.setSelectedStaticPage(staticPage);
        spvm.setStaticPages(this.findAllStaticPages(Integer.MAX_VALUE, 0));
        spvm.setCategories(categoryService.findAllCategories(Integer.MAX_VALUE, 0));
        return spvm;

    }

    @Override
    public StaticPage buildStaticPageFromStaticPageCommandModel(StaticPageCommandModel spcm) {

        StaticPage staticPage = new StaticPage();
        if (spcm.getStaticPageId() != null) {
            staticPage.setStaticPageId(spcm.getStaticPageId());
        }
        staticPage.setStaticPageTitle(spcm.getStaticPageTitle());
        staticPage.setStaticPageContent(spcm.getStaticPageContent());
        return staticPage;

    }

}
