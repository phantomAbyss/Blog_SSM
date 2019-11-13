package com.wy.blog.service.impl;

import com.wy.blog.dao.MenuDao;
import com.wy.blog.domain.Menu;
import com.wy.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> findAll() {
        return menuDao.findAll();
    }
}
