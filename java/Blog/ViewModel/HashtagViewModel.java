/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ViewModel;

import Blog.Dto.Hashtag;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class HashtagViewModel {
    
    private Hashtag selectedHashtag;
    
    List<Hashtag> hashtags;

    public Hashtag getSelectedHashtag() {
        return selectedHashtag;
    }

    public void setSelectedHashtag(Hashtag selectedHashtag) {
        this.selectedHashtag = selectedHashtag;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }    
    
}
