/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.CommandModel.PostCommandModel;
import Blog.Dto.Post;
import Blog.Dto.StaticPage;
import Blog.Service.PostServiceInterface;
import Blog.Service.StaticPageServiceInterface;
import Blog.ViewModel.PostViewModel;
import Blog.ViewModel.SinglePostViewModel;
import Blog.ViewModel.StaticPageViewModel;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeffc
 */
@Controller
public class PostController {
    
    private PostServiceInterface postService;
    private StaticPageServiceInterface staticPageService;

    public PostController(PostServiceInterface postService, StaticPageServiceInterface staticPageService) {
        this.postService = postService;
        this.staticPageService = staticPageService;
    }

    @RequestMapping(value = "/CreatePost", method = RequestMethod.GET)
    public String displayCreatePostPage(Model model) {
        List<StaticPage> spvm = staticPageService.findAllStaticPages(100, 0);        
        model.addAttribute("spvm", spvm);
        return "/CreatePost";
    }   

    @RequestMapping(value= "/CreatePost", method = RequestMethod.POST)
    public String createPost(@Valid @ModelAttribute("pcm") PostCommandModel pcm, BindingResult result) {       
        Post post = postService.buildPostFromPostCommandModel(pcm);
        LocalDateTime ldt = LocalDateTime.now();
        post.setStartDate(ldt);
        post.setEndDate(ldt);
        post.setCreateDate(ldt);
        post.setApprovalDate(ldt);
        post.setApproval(false);
        post = postService.createPost(post);      
        return "redirect:/";        
    }
    
    @RequestMapping(value = "/UpdatePostPage", method = RequestMethod.GET)
    public String displayUpdatePostPage(@RequestParam("postId") Integer postId, Model model) {
        Post post = postService.getPostById(postId);
        SinglePostViewModel spvm = postService.buildSinglePostViewModelFromPost(post);
        model.addAttribute("spvm", spvm);      
        return "/UpdatePost";
    }    

    @RequestMapping(value= "/UpdatePost", method = RequestMethod.POST)
    public String updatePost(@Valid @ModelAttribute("pcm") PostCommandModel pcm, BindingResult result) {       
        Post post = postService.buildPostFromPostCommandModel(pcm);
        LocalDateTime ldt = LocalDateTime.now();
        post.setStartDate(ldt);
        post.setEndDate(ldt);
        post.setCreateDate(ldt);
        post.setApprovalDate(ldt);
        post.setApproval(false);        
        post = postService.updatePost(post);       
        return "redirect:/AdminManagePosts/displayPostAdminPage";       
    }

    @RequestMapping(value = "/DeletePostPage", method = RequestMethod.GET)
    public String displayDeletePostPage(@RequestParam("postId") Integer postId, Model model) {
        model.addAttribute("postId", postId);        
        return "/DeletePost";
    }    

    @RequestMapping(value= "/DeletePost", method = RequestMethod.POST)
    public String deletePost(@RequestParam("postId") Integer postId) {       
        try {
            postService.deletePost(postId);
        }   catch (Exception e) {           
        }       
        return "redirect:/AdminManagePosts/displayPostAdminPage";      
    }       
    
}
