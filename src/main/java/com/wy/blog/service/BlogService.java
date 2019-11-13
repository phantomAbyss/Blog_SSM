package com.wy.blog.service;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Blog;

import java.util.List;

public interface BlogService {

    /**
     * 添加一篇博客
     * @param blog
     */
    public void addBlog(Blog blog);

    /**
     * 根据页码和每页的大小得到所有地博客
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Blog> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 根据id查找博客
     * @param blogId
     * @param status
     * @return
     */
    Blog findBlogByIdAndStatus(Integer status, Integer blogId) throws Exception;

    /**
     * 根据id删除博客
     * @param id
     */
    void deleteBlogById(Integer id);

    /**
     * 更新博客信息
     * @param blog
     */
    void updateBlog(Blog blog);

    /**
     * 查询后一篇博客
     * @param status
     * @param blogId
     * @return
     */
    Blog findAfterBlog(Integer status, Integer blogId);

    /**
     * 查询前一篇博客
     * @param status
     * @param blogId
     * @return
     */
    Blog findPreBlog(Integer status, Integer blogId);

    /**
     * 修改文章的的评论数
     * @param commentArticleId
     */
    void updateCommentCount(Integer commentArticleId) throws Exception;

    /**
     * 根据分类的id查询相关联的博客
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    PageInfo<Blog> getBlogListByCategoryId(Integer pageNum, Integer pageSize, Integer categoryId) throws Exception;

    /**
     * 获取随机文章
     * @param num
     * @return
     */
    List<Blog> getBlogListRandom(Integer num) throws Exception;


    /**
     * 根据状态获取已经发布或者草稿的文章
     * @param status
     * @return
     */
    Integer countBlog(Integer status);

    /**
     * 获取所有文章的评论数量
     * @return
     */
    Integer countBlogComment();

    /**
     * 获取所有文章的阅读数量
     * @return
     */
    Integer countBlogViews();

    /**
     * 查询最后更新的文章
     * @return
     */
    Blog getLastUpdateBlog();

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param searchValue
     * @return
     */
    PageInfo<Blog> getBlogListByValue(Integer pageNum, Integer pageSize, String searchValue) throws Exception;

    /**
     * 分页查询博客的时间轴
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Blog> getBlogTime(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 博客的阅读量加1
     * @param blogId
     * @return
     */
    Blog addViewsCount(Integer blogId) throws Exception;
}
