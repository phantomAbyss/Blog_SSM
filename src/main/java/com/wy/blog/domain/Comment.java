package com.wy.blog.domain;

import java.util.Date;

public class Comment {
    private Integer commentId;
    private Integer commentPid;
    private String commentPname;
    private Integer commentArticleId;
    private String commentAuthorName;
    private String commentAuthorEmail;
    private String commentAuthorUrl;
    private String commentAuthorAvatar;
    private String commentContent;
    private String commentAgent;
    private String commentIp;
    private Date commentTime;
    private Integer commentRole;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public String getCommentPname() {
        return commentPname;
    }

    public void setCommentPname(String commentPname) {
        this.commentPname = commentPname;
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    public String getCommentAuthorAvatar() {
        return commentAuthorAvatar;
    }

    public void setCommentAuthorAvatar(String commentAuthorAvatar) {
        this.commentAuthorAvatar = commentAuthorAvatar;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentRole() {
        return commentRole;
    }

    public void setCommentRole(Integer commentRole) {
        this.commentRole = commentRole;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentPid=" + commentPid +
                ", commentPname='" + commentPname + '\'' +
                ", commentArticleId=" + commentArticleId +
                ", commentAuthorName='" + commentAuthorName + '\'' +
                ", commentAuthorEmail='" + commentAuthorEmail + '\'' +
                ", commentAuthorUrl='" + commentAuthorUrl + '\'' +
                ", commentAuthorAvatar='" + commentAuthorAvatar + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentAgent='" + commentAgent + '\'' +
                ", commentIp='" + commentIp + '\'' +
                ", commentTime=" + commentTime +
                ", commentRole=" + commentRole +
                '}';
    }
}
