package com.wy.blog.controller.blog;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Blog;
import com.wy.blog.service.BlogService;
import com.wy.blog.service.CategoryService;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/{id}")
    public String showBlog(@PathVariable("id") Integer blogId,@RequestParam(value = "status",defaultValue = "1") Integer status,
                           Model model) throws Exception{
        //根据博客的状态查询博客的信息
        Blog blog = blogService.findBlogByIdAndStatus(status,blogId);
        //将MarkDown的内容转化为HTML的形式在页面显示
        blog.setContent(new PegDownProcessor().markdownToHtml(blog.getContent()));
        model.addAttribute("blog",blog);

        //得到博客的下一篇博客的信息
        Blog afterBlog = blogService.findAfterBlog(1,blogId);
        model.addAttribute("afterBlog",afterBlog);

        //上一篇博客的信息
        Blog preBlog = blogService.findPreBlog(1,blogId);
        model.addAttribute("preBlog",preBlog);

        return "blog/blogInfo";
    }

    @RequestMapping("/search")
    public String searchBlog(
            @RequestParam("searchValue") String searchValue,
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize,Model model) throws Exception {
        //根据关键字进行模糊查询
        PageInfo<Blog> pageInfo = blogService.getBlogListByValue(pageNum,pageSize,searchValue);
        System.out.println(searchValue);
        return "/blog/search";
    }

    @RequestMapping(value = "/time")
    public String blogTime(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                           Model model) throws Exception {
        PageInfo<Blog> pageInfo = blogService.getBlogTime(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/blog/time";
    }

    @RequestMapping(value = "/view/{blogId}")
    @ResponseBody
    public String addViewsCount(@PathVariable("blogId") Integer blogId) throws Exception {
        Blog blog = blogService.addViewsCount(blogId);
        System.out.println(blog.getViewCount());
        return JSON.toJSONString(blog.getViewCount());
    }
}
