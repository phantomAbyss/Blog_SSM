package com.wy.blog.dao;

import com.wy.blog.domain.Tag;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagDao {


    /**
     * 得到所有标签的信息
     * @return
     */
    @Select("select * from tag")
    List<Tag> findAll() throws Exception;

    /**
     * 得到所有标签的数量
     * @return
     */
    @Select("select count(*) from tag")
    Integer countTag();

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @Select("select * from tag where tagId in (" +
            "select tagId from blog_tag where blogId = #{blogId})")
    List<Tag> getTagListByBlogId(@Param("blogId") Integer blogId);

    /**
     * 根据id查询
     * @param tagId
     * @return
     */
    @Select("select * from tag where tagId = #{tagId}")
    Tag getTagByTagId(@Param("tagId") Integer tagId) throws Exception;
}
