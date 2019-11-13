package com.wy.blog.dao;

import com.wy.blog.domain.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuDao {

    /**
     * 得到所有的菜单选项
     * @return
     */
    @Select("select * from menu")
    List<Menu> findAll();
}
