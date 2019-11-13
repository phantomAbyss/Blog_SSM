package com.wy.blog.domain;


import java.util.Date;
import java.util.List;

public class Blog {
    private int id;
    private int userId;
    private String title;
    private String blogDesc;
    private String content;
    private int viewCount;
    private int commentCount;
    private int likeCount;
    private Date updateTime;
    private String updateTimeStr;
    private Date blogTime;
    private String blogTimeStr;
    private int status;

    private UserInfo userInfo;
    private List<Category> categoryList;
    private List<Tag> tagList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Date getBlogTime() {
        return blogTime;
    }

    public void setBlogTime(Date blogTime) {
        this.blogTime = blogTime;
    }

    public String getBlogTimeStr() {
        return blogTimeStr;
    }

    public void setBlogTimeStr(String blogTimeStr) {
        this.blogTimeStr = blogTimeStr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", blogDesc='" + blogDesc + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", commentCount=" + commentCount +
                ", likeCount=" + likeCount +
                ", updateTime=" + updateTime +
                ", updateTimeStr='" + updateTimeStr + '\'' +
                ", blogTime=" + blogTime +
                ", blogTimeStr='" + blogTimeStr + '\'' +
                ", status=" + status +
                ", userInfo=" + userInfo +
                ", categoryList=" + categoryList +
                ", tagList=" + tagList +
                '}';
    }
}
