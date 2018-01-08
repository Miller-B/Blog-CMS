/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dto;

import java.util.Objects;

/**
 *
 * @author EJB Laptop
 */
public class PostHashtag {
    
    private Integer postHashtagId;
    
    private Post post;
    
    private Hashtag hashtag;

    public Integer getPostHashtagId() {
        return postHashtagId;
    }

    public void setPostHashtagId(Integer postHashtagId) {
        this.postHashtagId = postHashtagId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Hashtag getHashtag() {
        return hashtag;
    }

    public void setHashtag(Hashtag hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.postHashtagId);
        hash = 43 * hash + Objects.hashCode(this.post);
        hash = 43 * hash + Objects.hashCode(this.hashtag);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PostHashtag other = (PostHashtag) obj;
        if (!Objects.equals(this.postHashtagId, other.postHashtagId)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.hashtag, other.hashtag)) {
            return false;
        }
        return true;
    }
    
}
