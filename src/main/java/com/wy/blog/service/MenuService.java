package com.wy.blog.service;

import com.wy.blog.domain.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 查询所有菜单选项
     * @return
     */
    List<Menu> findAll();
}
