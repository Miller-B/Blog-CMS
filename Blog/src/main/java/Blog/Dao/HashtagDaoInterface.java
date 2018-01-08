/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Service.BlogServiceException;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface HashtagDaoInterface {
    
    public Hashtag createHashtag(Hashtag hashtag);
    
    public Hashtag getHashtagById(Integer hashtagId);
    
    public List<Hashtag> findAllHashtags(int limit, int offset);
    
    public Hashtag updateHashtag(Hashtag hashtag);
    
    public void deleteHashtag(Integer hashtagId)throws BlogServiceException;
    
    public List<Hashtag> findAllHashtagsByPost(Post post, int limit, int offset);
    
}
