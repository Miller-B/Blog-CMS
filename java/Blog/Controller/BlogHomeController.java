/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.Dto.StaticPage;
import Blog.Service.PostServiceInterface;
import Blog.Service.StaticPageServiceInterface;
import Blog.ViewModel.PostViewModel;
import Blog.ViewModel.StaticPageViewModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeffc
 */
@Controller
public class BlogHomeController {

    private PostServiceInterface postService;
    private StaticPageServiceInterface staticPageService;
    public BlogHomeController(PostServiceInterface postService, StaticPageServiceInterface staticPageService) {
        this.postService = postService;
        this.staticPageService = staticPageService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayBlogHomePage(Model model) {
        PostViewModel pvm = postService.getPostViewModelByDate(postService.createFirstPostAutomatically(), 100, 0);
        model.addAttribute("pvm", pvm);
        List<StaticPage> spvm = staticPageService.findAllStaticPages(100, 0);        
        model.addAttribute("spvm", spvm);
        return "/BlogHome";
    }

    
    @RequestMapping(value = "/BlogHome/ByHashtag", method = RequestMethod.GET)
    public String displayBlogPostsByHashtag(@RequestParam("hashtagId") Integer hastagId, Model model) {
        PostViewModel pvm = postService.getPostViewModelByHashtag(postService.createFirstPostAutomatically(), hastagId, 100, 0);
        model.addAttribute("pvm", pvm);
        return "/BlogHome";
    }

    
}
