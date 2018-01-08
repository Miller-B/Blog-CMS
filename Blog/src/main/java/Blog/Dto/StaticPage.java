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
public class StaticPage {
    
    private Integer staticPageId;
    
    private String staticPageTitle;
    
    private String staticPageContent;

    public Integer getStaticPageId() {
        return staticPageId;
    }

    public void setStaticPageId(Integer staticPageId) {
        this.staticPageId = staticPageId;
    }

    public String getStaticPageTitle() {
        return staticPageTitle;
    }

    public void setStaticPageTitle(String staticPageTitle) {
        this.staticPageTitle = staticPageTitle;
    }

    public String getStaticPageContent() {
        return staticPageContent;
    }

    public void setStaticPageContent(String staticPageContent) {
        this.staticPageContent = staticPageContent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.staticPageId);
        hash = 61 * hash + Objects.hashCode(this.staticPageTitle);
        hash = 61 * hash + Objects.hashCode(this.staticPageContent);
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
        final StaticPage other = (StaticPage) obj;
        if (!Objects.equals(this.staticPageTitle, other.staticPageTitle)) {
            return false;
        }
        if (!Objects.equals(this.staticPageContent, other.staticPageContent)) {
            return false;
        }
        if (!Objects.equals(this.staticPageId, other.staticPageId)) {
            return false;
        }
        return true;
    }
    
    
    
}
