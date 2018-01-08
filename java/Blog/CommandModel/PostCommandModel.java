/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.CommandModel;

import Blog.Dto.Category;
import Blog.Dto.Hashtag;
import Blog.Dto.User;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class PostCommandModel {

    private Integer postId;

    private Integer userId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime createDate;

    private LocalDateTime approvalDate;

    private Boolean approval;

    private String postTitle;

    private String postContent;

    private Integer categoryId;
    
    private Integer[] hashtags;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(Integer[] hashtags) {
        this.hashtags = hashtags;
    }

   
}
