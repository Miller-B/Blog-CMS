/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ViewModel;

import Blog.Dto.Category;
import Blog.Dto.Post;
import Blog.Dto.StaticPage;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class PostViewModel {
 
    private SinglePostViewModel selectedPost;
    
    private List<SinglePostViewModel> spvms;
    
    private List<StaticPage> staticPages;
    
    private List<Category> categories;

    public SinglePostViewModel getSelectedPost() {
        return selectedPost;
    }

    public void setSelectedPost(SinglePostViewModel selectedPost) {
        this.selectedPost = selectedPost;
    }

    public List<SinglePostViewModel> getSpvms() {
        return spvms;
    }

    public void setSpvms(List<SinglePostViewModel> spvms) {
        this.spvms = spvms;
    }

    public List<SinglePostViewModel> getSinglePostViewModels() {
        return spvms;
    }

    public void setSinglePostViewModels(List<SinglePostViewModel> spvms) {
        this.spvms = spvms;
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
