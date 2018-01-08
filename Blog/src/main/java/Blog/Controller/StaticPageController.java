/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.Dto.StaticPage;
import Blog.Service.StaticPageServiceInterface;
import Blog.ViewModel.StaticPageViewModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author BMMil
 */
@Controller
@RequestMapping({"StaticPage"})
public class StaticPageController {

    
    private StaticPageServiceInterface sPageService;
    
    public StaticPageController(StaticPageServiceInterface sPageService) {
        this.sPageService = sPageService;
    }
    
    @RequestMapping(value="/displaySelectedStaticPage", method=RequestMethod.GET)
    public String displaySelectedStaticPage(HttpServletRequest request, @RequestParam("staticPageId") Integer staticPageId, Model model) {
      
        StaticPageViewModel spvm = sPageService.buildStaticPageViewModelFromStaticPage(sPageService.getStaticPageById(staticPageId));
        List<StaticPage> spvml = sPageService.findAllStaticPages(100, 0);
        model.addAttribute("spvm", spvm);
        model.addAttribute("spvml", spvml);
        return "/StaticPageRead";
    }
    
    
}
    

