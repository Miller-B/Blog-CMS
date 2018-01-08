/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ViewModel;

import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class SinglePostViewModel {
    
    private Post post;
    
    private List<Hashtag> hashtags;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
    
    
    
}
