package com.wy.blog.dao;

import com.wy.blog.domain.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {

    /**
     *
     * @return
     */
    @Select("select * from category")
    List<Category> findAll() throws Exception;

    /**
     * 根据id查询对应的分类信息
     * @param categoryId
     * @return
     */
    @Select("select * from category where categoryId = #{categoryId}")
    Category getCategoryById(Integer categoryId) throws Exception;

    /**
     * 获取所有的目录数
     * @return
     */
    @Select("select count(*) from category")
    Integer countCategory();

    /**
     * 得到子标签的数目
     * @param categoryId
     * @return
     */
    @Select("select count(*) from category where categoryPid = #{categoryId}")
    Integer getChildCount(@Param("categoryId") Integer categoryId);

    /**
     * 得到该目录下对应的博客数量
     * @param categoryId
     * @return
     */
    @Select("select count(*) from blog_category where categoryId = #{categoryId}")
    Integer getBlogCount(@Param("categoryId") Integer categoryId);

    /**
     * 根据博客的id查询该博客包含的目录
     * @param blogId
     * @return
     */
    @Select("select * from category where categoryId in (" +
            "select categoryId from blog_category where blogId = #{blogId})")
    List<Category> getCategoryListByBlogId(@Param("blogId") Integer blogId) throws Exception;
}
