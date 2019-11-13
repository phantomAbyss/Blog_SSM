package com.wy.blog.controller.blog;


import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Blog;
import com.wy.blog.domain.Category;
import com.wy.blog.domain.Tag;
import com.wy.blog.service.BlogService;
import com.wy.blog.service.CategoryService;
import com.wy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 使用RestController注解的结果是Spring MVC controller处理器，并且直接把返回结果直接写入HTTP response body中，
 * 因此当controller中的方法的返回值为String时，字符串不会被解析成跳转路径，而是直接将字符串显示到页面上，
 * 因此页面就不会跳转。
 */
@Controller
@RequestMapping("/blog")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;



    @RequestMapping("/category/{id}")
    public String getBlogListByCategory(@PathVariable("id") Integer categoryId,
                                        @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                        Model model) throws Exception{
        //得到文章分类信息
        Category category = categoryService.getCategoryById(categoryId);
        if(category == null){
            return "redirect:/404";
        }
        model.addAttribute("category",category);

        //得到该分类下的所有已经的文章
        PageInfo<Blog> pageInfo = blogService.getBlogListByCategoryId(pageNum,pageSize,categoryId);
        model.addAttribute("pageInfo",pageInfo);

        //侧边栏：标签列表显示
        List<Tag> tagList = tagService.findAll();
        model.addAttribute("tagList",tagList);

        //获取随机文章
        List<Blog> randomBlogList = blogService.getBlogListRandom(8);
        model.addAttribute("randomList",randomBlogList);

        return "blog/blogCategory";
    }

}
