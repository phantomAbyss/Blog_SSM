package com.wy.blog.dao;


import com.wy.blog.domain.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BlogDao {

    /**
     * 添加一篇博客
     * @param blog
     */
    @Insert("insert into blog(userId,title,blogDesc,content,viewCount,commentCount,updateTime,blogTime,likeCount,status) " +
            " values(#{userId},#{title},#{blogDesc},#{content}," +
            "#{viewCount},#{commentCount},#{updateTime},#{blogTime},#{likeCount},#{status})")
    void addBlog(Blog blog);

    /**
     * 根据博客id查询
     * 1、当传递给方法只有一个参数的时候，是可以不用注解的，mybatis可以自动匹配参数
     * 2.当有多个传递参数时，必须使用@Parm("XX")注解指明参数名称，不然就会报BindingException异常，mybatis就匹配不了参数
     * @param status
     * @param blogId
     * @return
     */
    @Select("<script>" +
            "select * from blog" +
            " <where>" +
            "   <if test='status != null'>" +
            "       and status = #{status}" +
            "   </if>" +
            "   <if test='blogId != null'>" +
            "       and id = #{blogId}" +
            "   </if>" +
            " </where>" +
            "</script>")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "blogDesc",column = "blogDesc"),
            @Result(property = "content",column = "content"),
            @Result(property = "viewCount",column = "viewCount"),
            @Result(property = "commentCount",column = "commentCount"),
            @Result(property = "updateTime",column = "updateTime"),
            @Result(property = "blogTime",column = "blogTime"),
            @Result(property = "likeCount",column = "likeCount"),
            @Result(property = "status",column = "status"),
            @Result(property = "userInfo",column = "userId",javaType = Blog.class,
                    one = @One(select = "com.wy.blog.dao.UserDao.getUserInfoById")),
    })
    List<Blog> findAll(@Param("status") Integer status, @Param("blogId") Integer blogId) throws Exception;

    /**
     * 删除博客
     * @param id
     */
    @Delete("delete from blog where id = #{blogId}")
    Integer delete(Integer blogId);

    /**
     * 删除博客
     * @param blog
     */
    @Update("update blog set title=#{title},blogDesc=#{blogDesc}," +
            "content=#{content},updateTime=#{updateTime},status=#{status} where id = #{id}")
    void update(Blog blog);

    /**
     * 得到博客的总篇数
     * @return
     */
    @Select("select count(*) from blog")
    Integer blogCount();

    /**
     * 修改文章的评论数
     * @param blogId
     */
    @Update("update blog set commentCount = (select count(*) from comment where commentArticleId = #{blogId}) " +
            "where id = #{blogId}")
    void updateCommentCount(@Param("blogId") Integer blogId) throws Exception;

    /**
     * 通过id查找当前文章的下一篇文章
     * @param status
     * @param blogId
     * @return
     */
    @Select("select * from blog where status = #{status} and id > #{id} order by id limit 1")
    Blog findAfterBlog(@Param("status") Integer status, @Param("id") Integer blogId);

    /**
     * 通过当前文章id查找前一篇文章
     * @param status
     * @param blogId
     * @return
     */
    @Select("select * from blog where status = #{status} and id < #{id} order by id desc limit 0,1")
    Blog findPreBlog(@Param("status") Integer status, @Param("id") Integer blogId);

    /**
     * 根据id查询对应分类下的文章
     * @param categoryId
     * @return
     */
    @Select("select * from blog where id in (" +
            "select blogId from blog_category where categoryId = #{categoryId}) and status = 1")
    List<Blog> getBlogListByCategoryId(@Param("categoryId") Integer categoryId) throws Exception;

    /**
     * 获取随机文章
     * @param num
     * @return
     */
    @Select("select * from blog where status = 1 order by rand() limit #{num}")
    List<Blog> getBlogListRandom(@Param("num") Integer num) throws Exception;


    /**
     * 根据状态获取已经发布或者草稿的文章
     * @param status
     * @return
     */
    @Select("select count(*) from blog")
    Integer countBlog(Integer status);

    /**
     * 得到所有文章的评论数
     * @return
     */
    @Select("select sum(commentCount) from blog where status = 1")
    Integer countBlogComment();

    /**
     * 获取所有文章的阅读的数量
     * @return
     */
    @Select("select sum(viewCount) from blog where status = 1")
    Integer countBlogViews();

    /**
     * 得到最新更新的文章
     * @return
     */
    @Select("select * from blog where status = 1 and updateTime = " +
            "(select max(updateTime) from blog where status = 1)")
    Blog getLastBlog();

    /**
     * 根据值进行模糊查询
     * @param status
     * @param searchValue
     * @return
     */
    @Select("select * from blog where status = #{status} and content like #{value}")
    List<Blog> getBlogListByValue(@Param("status") Integer status, @Param("value") String searchValue) throws Exception;

    /**
     * 按时间分页查询博客
     * @return
     */
    @Select("select * from blog order by blogTime desc")
    List<Blog> getBlogTime() throws Exception;

    /**
     * 添加阅读量
     * @param blogId
     * @return
     */
    @Update("update blog set viewCount = viewCount + 1 where id = #{blogId}")
    Blog addViewsCount(@Param("blogId") Integer blogId) throws Exception;

    /**
     * 删除博客和目录的对应关系
     * @param id
     */
    @Delete("delete from blog_category where blogId = #{blogId}")
    Integer deleteBlogAndCategoryById(@Param("blogId") Integer blogId);

    /**
     * 删除博客和标签的对应关系
     * @param blogId
     * @return
     */
    @Delete("delete from blog_tag where blogId = #{blogId}")
    Integer deleteBlogAndTag(Integer blogId);

}
