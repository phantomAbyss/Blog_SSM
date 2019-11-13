package com.wy.blog.dao;

import org.apache.ibatis.annotations.Select;

public interface LinkDao {


    /**
     * 根据状态获取链接数量
     * @param status
     * @return
     */
    @Select("select count(*) from link")
    Integer countLink(Integer status);
}
