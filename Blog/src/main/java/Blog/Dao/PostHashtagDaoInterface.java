/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.PostHashtag;
import Blog.Service.BlogServiceException;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface PostHashtagDaoInterface {
    
    public PostHashtag createPostHashtag(PostHashtag postHashtag);
    
    public PostHashtag getPostHashtagById(Integer postHashtagId);
    
    public List<PostHashtag> findAllPostHashtags(int limit, int offset);
    
    public PostHashtag updatePostHashtag(PostHashtag postHashtag);
    
    public void deletePostHashtag(Integer postHashtagId) throws BlogServiceException;
    
    public List<PostHashtag> findAllPostHashtagsByPost(Post post, int limit, int offset);
            
    public List<PostHashtag> findAllPostHashtagsByHashtag(Hashtag hashtag, int limit, int offset);
    
    public void deletePostHashtagByPost(Post post);
    
    public void deletePostHashtagByHashtag(Hashtag hashtag);
    
}
