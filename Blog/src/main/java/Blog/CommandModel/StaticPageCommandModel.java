/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.CommandModel;

/**
 *
 * @author jeffc
 */
public class StaticPageCommandModel {
    
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

    
    
}
