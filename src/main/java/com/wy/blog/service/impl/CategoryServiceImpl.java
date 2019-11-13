package com.wy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.blog.dao.CategoryDao;
import com.wy.blog.domain.Category;
import com.wy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    public List<Category> getCategoryList(Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum,pageSize);
        List<Category> categoryList = categoryDao.findAll();
        for (Category category : categoryList) {
            category.setChildCategoryCount(categoryDao.getChildCount(category.getCategoryId()));
            category.setBlogCount(categoryDao.getBlogCount(category.getCategoryId()));
        }
        return categoryList;
    }

    public List<Category> findAll() throws Exception {
        List<Category> categoryList = categoryDao.findAll();
        for (Category category : categoryList) {
            category.setChildCategoryCount(categoryDao.getChildCount(category.getCategoryId()));
            category.setBlogCount(categoryDao.getBlogCount(category.getCategoryId()));
        }
        return categoryList;
    }

    public Category getCategoryById(Integer categoryId) throws Exception {
        return categoryDao.getCategoryById(categoryId);
    }


    public Integer countCategory() {
        return categoryDao.countCategory();
    }

    public Integer getChildCount(Integer categoryId) {
        return categoryDao.getChildCount(categoryId);
    }
}
