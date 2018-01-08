/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.CommandModel.PostCommandModel;
import Blog.CommandModel.StaticPageCommandModel;
import Blog.Dto.StaticPage;
import Blog.Service.StaticPageServiceInterface;
import Blog.ViewModel.StaticPageViewModel;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import static org.springframework.http.RequestEntity.post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author BMMil
 */
@Controller
@RequestMapping({"AdminManagePages"})
public class AdminManagePagesController {

    private StaticPageServiceInterface sPageService;

    public AdminManagePagesController(StaticPageServiceInterface sPageService) {
        this.sPageService = sPageService;
    }

    @RequestMapping(value = "/displayPageAdminPage", method = RequestMethod.GET)
    public String displayPageAdminPage(Model model) {
        List<StaticPage> spvm = sPageService.findAllStaticPages(100, 0);
        model.addAttribute("spvm", spvm);
        return "/AdminManagePages";
    }
    
    @RequestMapping(value = "/displayUpdatePage", method = RequestMethod.GET)
    public String displayUpdatePage(@RequestParam("staticPageId") Integer staticPageId, Model model) {
        StaticPage staticPage = sPageService.getStaticPageById(staticPageId);
        StaticPageViewModel spvm = sPageService.buildStaticPageViewModelFromStaticPage(staticPage);
        model.addAttribute("spvm", spvm);
        return "/UpdatePage";
    }
       
    @RequestMapping(value= "/UpdatePage", method = RequestMethod.POST)
    public String updatePage(@Valid @ModelAttribute("spcm") StaticPageCommandModel spcm, BindingResult result, Model model) {               
        StaticPage staticPage = sPageService.buildStaticPageFromStaticPageCommandModel(spcm);
        staticPage = sPageService.updateStaticPage(staticPage);
        List<StaticPage> spvm = sPageService.findAllStaticPages(100, 0);
        model.addAttribute("spvm", spvm);
        return "/AdminManagePages";       
    }

       @RequestMapping(value = "/displayDeletePage", method = RequestMethod.GET)
    public String displayDeletePage(@RequestParam("staticPageId") Integer staticPageId, Model model) {
        model.addAttribute("staticPageId", staticPageId);        
        return "/DeletePage";
    }    

    @RequestMapping(value= "/DeletePage", method = RequestMethod.POST)
    public String deletePost(@RequestParam("staticPageId") Integer staticPageId) {       
        sPageService.deleteStaticPage(staticPageId);          
        return "/AdminManagePages";      
    }       
    
    @RequestMapping(value = "/createPage", method = RequestMethod.GET)
    public String displayCreatePage(Model model) {
        return "/CreatePage";
    }

    @RequestMapping(value= "/CreatePage", method = RequestMethod.POST)
    public String createPage(@Valid @ModelAttribute("spcm") StaticPageCommandModel spcm, BindingResult result, Model model) {       
        StaticPage staticPage = sPageService.buildStaticPageFromStaticPageCommandModel(spcm);       
        sPageService.createStaticPage(staticPage);
        return "/AdminManagePages";        
    }
    
}
