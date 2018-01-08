/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.CommandModel.PostCommandModel;
import Blog.Dto.Post;
import Blog.Service.PostServiceInterface;
import Blog.ViewModel.PostViewModel;
import java.time.LocalDateTime;
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
 * @author EJB Laptop
 */
@Controller
@RequestMapping({"AdminManagePosts"})
public class AdminPostsController {
    
    private PostServiceInterface postService;

    public AdminPostsController(PostServiceInterface postService) {
        this.postService = postService;
    }
    
    @RequestMapping(value = "/displayPostAdminPage", method = RequestMethod.GET)
    public String displayPostAdminPage(Model model) {
        PostViewModel avm = postService.getPostViewModelByDate(postService.createFirstPostAutomatically(), 100, 0);
        model.addAttribute("avm", avm);
        return "/AdminManagePosts";
    }
    
    @RequestMapping(value = "/ByHashtag", method = RequestMethod.GET)
    public String displayBlogPostsByHashtagAdmin(@RequestParam("hashtagId") Integer hastagId, Model model) {
        PostViewModel avm = postService.getPostViewModelByHashtag(postService.createFirstPostAutomatically(), hastagId, 100, 0);
        model.addAttribute("avm", avm);
        return "/AdminManagePosts";
    }
    
    //apprroval methods go herre
    @RequestMapping(value="/displayPostApprovePage", method = RequestMethod.GET)
    public String displayApprovePostPage(Model model) {
        PostViewModel avm = postService.getPostViewModelByDate(postService.createFirstPostAutomatically(), 100, 0);
        model.addAttribute("avm", avm);
        return "/ApprovePosts";
    }
    
    @RequestMapping(value= "/approvePost", method = RequestMethod.GET)
    public String adminApprovedPost(Model model, @RequestParam(value="postId") Integer postId) {        
        Post post = postService.getPostById(postId);  
        LocalDateTime ldt = LocalDateTime.now();
        post.setApprovalDate(ldt);
        post.setApproval(true);        
        postService.updatePost(post); 
        PostViewModel avm = postService.getPostViewModelByDate(postService.createFirstPostAutomatically(), 100, 0);
        model.addAttribute("avm", avm);
        return "/ApprovePosts";
    }
    
}
