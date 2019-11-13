package com.wy.blog.service;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Comment;

public interface CommentService {

    /**
     * 添加一条新的评论
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 查询所有评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Comment> findAllComment(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 根据id删除评论
     * @param commentId
     */
    void deleteCommentByCommentId(Integer commentId);
}
