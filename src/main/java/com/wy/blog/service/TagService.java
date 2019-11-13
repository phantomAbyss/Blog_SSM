package com.wy.blog.service;

import com.wy.blog.domain.Tag;

import java.util.List;

public interface TagService {


    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findAll() throws Exception;

    /**
     * 获取所有标签的数量
     * @return
     */
    Integer countTag();

    /**
     * 获取所有标签
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Tag> getTagList(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 根据id查询
     * @param tagId
     * @return
     */
    Tag getTagByTagId(Integer tagId) throws Exception;
}
