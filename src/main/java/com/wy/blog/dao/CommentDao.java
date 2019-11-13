package com.wy.blog.dao;

import com.wy.blog.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentDao {

    /**
     * 添加一条评论
     * @param comment
     */
    @Insert("insert into comment(commentPid,commentPname,commentArticleId,commentAuthorName,commentAuthorEmail,commentAuthorUrl,commentAuthorAvatar," +
            "commentContent,commentAgent,commentIp,commentTime,commentRole) " +
            "values(#{commentPid},#{commentPname},#{commentArticleId},#{commentAuthorName},#{commentAuthorEmail},#{commentAuthorUrl}," +
            "#{commentAuthorAvatar},#{commentContent},#{commentAgent},#{commentIp},#{commentTime},#{commentRole})")
    void addComment(Comment comment);


    /**
     * 根据文章id得到文章的评论数
     * @param articleId
     * @return
     */
    @Select("select count(*) from comment where commentArticleId = #{articleId}")
    Integer commentCount(Integer articleId);

    /**
     * 查询所有的评论
     * @return
     */
    @Select("select * from comment")
    List<Comment> findAllComment() throws Exception;

    /**
     * 根据id删除评论
     * @param commentId
     */
    @Delete("delete from comment where commentId = #{commentId}")
    void delete(@Param("commentId") Integer commentId);
}
