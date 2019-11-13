package com.wy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.blog.dao.CommentDao;
import com.wy.blog.domain.Comment;
import com.wy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    public PageInfo<Comment> findAllComment(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentDao.findAllComment();
        return new PageInfo<Comment>(commentList);
    }

    public void deleteCommentByCommentId(Integer commentId) {
        commentDao.delete(commentId);
    }
}
