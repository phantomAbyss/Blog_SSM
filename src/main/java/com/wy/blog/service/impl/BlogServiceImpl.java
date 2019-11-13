package com.wy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.blog.dao.BlogDao;
import com.wy.blog.dao.CategoryDao;
import com.wy.blog.dao.TagDao;
import com.wy.blog.domain.Blog;
import com.wy.blog.domain.Category;
import com.wy.blog.domain.Tag;
import com.wy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("blogService")
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private TagDao tagDao;


    /**
     * 添加一篇博客
     * @param blog
     */
    public void addBlog(Blog blog){
        blogDao.addBlog(blog);
    }

    public PageInfo<Blog> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogDao.findAll(null,null);
        for (Blog blog : blogList) {
            List<Category> categoryList = categoryDao.getCategoryListByBlogId(blog.getId());
            blog.setCategoryList(categoryList);
            List<Tag> tagList = tagDao.getTagListByBlogId(blog.getId());
            blog.setTagList(tagList);
        }
        return new PageInfo<Blog>(blogList);
    }

    public Blog findBlogByIdAndStatus(Integer status,Integer blogId) throws Exception {
        return blogDao.findAll(status,blogId).get(0);
    }

    public void deleteBlogById(Integer id) {
        //先删除博客和目录的对应关系
        blogDao.deleteBlogAndCategoryById(id);
        //删除博客和标签的对应关系
        blogDao.deleteBlogAndTag(id);
        //删除博客
        blogDao.delete(id);
    }

    public void updateBlog(Blog blog) {
        blogDao.update(blog);
    }

    public Blog findAfterBlog(Integer status, Integer blogId) {
        return blogDao.findAfterBlog(status,blogId);
    }

    public Blog findPreBlog(Integer status, Integer blogId) {
        /*//如果博客已经是第一篇博客，直接返回null
        if(blogId == 1)
            return null;
        //否则返回上一篇博客
        return blogDao.findBlogByIdAndStatus(status,blogId);*/
        return blogDao.findPreBlog(status,blogId);

    }

    public void updateCommentCount(Integer commentArticleId) throws Exception {
        blogDao.updateCommentCount(commentArticleId);
    }

    public PageInfo<Blog> getBlogListByCategoryId(Integer pageNum, Integer pageSize, Integer categoryId) throws Exception {
        //分页查询
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogDao.getBlogListByCategoryId(categoryId);
        for (Blog blog : blogList) {
            //为每一篇博客设置目录
            List<Category> categoryList = categoryDao.getCategoryListByBlogId(blog.getId());
            blog.setCategoryList(categoryList);
        }
        return new PageInfo<Blog>(blogList);
    }

    public List<Blog> getBlogListRandom(Integer num) throws Exception {
        return blogDao.getBlogListRandom(num);
    }

    public Integer countBlog(Integer status) {
        return blogDao.countBlog(status);
    }

    public Integer countBlogComment() {
        return blogDao.countBlogComment();
    }

    public Integer countBlogViews() {
        return blogDao.countBlogViews();
    }

    public Blog getLastUpdateBlog() {
        return blogDao.getLastBlog();
    }

    public PageInfo<Blog> getBlogListByValue(Integer pageNum, Integer pageSize, String searchValue) throws Exception{
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogDao.getBlogListByValue(1,"%" + searchValue + "%");
        return new PageInfo<Blog>(blogList);
    }

    public PageInfo<Blog> getBlogTime(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogDao.getBlogTime();
        return new PageInfo<Blog>(blogList);
    }

    public Blog addViewsCount(Integer blogId) throws Exception {
        return blogDao.addViewsCount(blogId);
    }
}
