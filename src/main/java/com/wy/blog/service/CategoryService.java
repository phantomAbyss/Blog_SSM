package com.wy.blog.service;

import com.wy.blog.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查找所有的库
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Category> getCategoryList(Integer pageNum, Integer pageSize) throws Exception;

    List<Category> findAll() throws Exception;

    /**
     * 根据id查询对应的分类信息
     * @param categoryId
     * @return
     */
    Category getCategoryById(Integer categoryId) throws Exception;

    /**
     * 统计所有的目录数
     * @return
     */
    Integer countCategory();

    /**
     * 查询该标签下的子标签的数目
     * @param categoryId
     * @return
     */
    Integer getChildCount(Integer categoryId);
}
