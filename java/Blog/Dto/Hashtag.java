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
public class Hashtag {
    
    private Integer hashtagId;
    
    private String tagName;

    public Integer getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(Integer hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.hashtagId);
        hash = 73 * hash + Objects.hashCode(this.tagName);
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
        final Hashtag other = (Hashtag) obj;
        if (!Objects.equals(this.tagName, other.tagName)) {
            return false;
        }
        if (!Objects.equals(this.hashtagId, other.hashtagId)) {
            return false;
        }
        return true;
    }
    
    
    
}
