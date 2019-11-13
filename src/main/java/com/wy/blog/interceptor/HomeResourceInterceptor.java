package com.wy.blog.interceptor;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Blog;
import com.wy.blog.domain.Category;
import com.wy.blog.domain.Menu;
import com.wy.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class HomeResourceInterceptor implements HandlerInterceptor {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取菜单选项
        List<Menu> menuList = menuService.findAll();
        request.setAttribute("menuList",menuList);

        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList",categoryList);

        //获取网页各项数据的数量
        List<String> siteBasicStatistics = new ArrayList<String>();
        //已经发布的文章的数量，1：表示已经发布
        siteBasicStatistics.add(blogService.countBlog(1) + "");
        //查询已经发布的文章的所获得的的评论数
        siteBasicStatistics.add(blogService.countBlogComment() + "");
        //查询目录的个数
        siteBasicStatistics.add(categoryService.countCategory() + "");
        //查询标签的个数
        siteBasicStatistics.add(tagService.countTag() + "");
        //查询链接的个数
        siteBasicStatistics.add(linkService.countLink(1) + "");
        //查询已经发布的文章的阅读数
        siteBasicStatistics.add(blogService.countBlogViews() + "");
        request.setAttribute("siteBasicStatistics",siteBasicStatistics);

        //获取最后更新的文章
        Blog blog = blogService.getLastUpdateBlog();
        request.setAttribute("lastUpdateBlog",blog);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
