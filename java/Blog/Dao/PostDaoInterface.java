/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Category;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.User;
import Blog.Service.BlogServiceException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface PostDaoInterface {
    
    public Post createPost(Post post);
    
    public Post getPostById(Integer postId);
    
    public List<Post> findAllPosts(int limit, int offset);
    
    public Post updatePost(Post post);
    
    public void deletePost(Integer postId) throws BlogServiceException;
    
    public List<Post> findAllPostsByUser(User user, int limit, int offset);
    
    public List<Post> findAllPostsByStartDate(LocalDateTime startDate, int limit, int offset);
    
    public List<Post> findAllPostsByEndDate(LocalDateTime endDate, int limit, int offset);
    
    public List<Post> findAllPostsByCreateDate(LocalDateTime createDate, int limit, int offset);
    
    public List<Post> findAllPostsByApprovalDate(LocalDateTime approvalDate, int limit, int offset);
    
    public List<Post> findAllPostsByApproval(int approval, int limit, int offset);
    
    public List<Post> findAllPostsByCategory(Category category, int limit, int offset);
    
    public List<Post> findAllPostsByHashtag(Hashtag hashtag, int limit, int offset);
    
}
