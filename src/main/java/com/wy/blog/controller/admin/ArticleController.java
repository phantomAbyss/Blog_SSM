package com.wy.blog.controller.admin;

import cn.hutool.http.HtmlUtil;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Blog;
import com.wy.blog.domain.Category;
import com.wy.blog.domain.Tag;
import com.wy.blog.domain.UserInfo;
import com.wy.blog.service.BlogService;
import com.wy.blog.service.CategoryService;
import com.wy.blog.service.TagService;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;


    /**
     * 查询所有已经编辑的博客
     * @return
     */
    @RequestMapping("")
    public ModelAndView index(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                        @RequestParam(required = false,defaultValue = "10")Integer pageSize) throws Exception{
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = blogService.findAll(pageNum,pageSize);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/index");
        return mv;
    }

    @RequestMapping("/blog")
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                @RequestParam(required = false,defaultValue = "10")Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = blogService.findAll(pageNum,pageSize);
        System.out.println(pageInfo.getList().get(0));
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/blog/index");
        return mv;
    }
    /**
     * 添加一篇博客
     * @param blog
     * @param session
     * @return
     */
    @RequestMapping(value = "/blog/add",method = RequestMethod.POST)
    public String addBlog(Blog blog, HttpSession session){
        System.out.println("开始提交数据");
        /*UserInfo user = (UserInfo) session.getAttribute("user");
        if(user != null){
            blog.setUserInfo(user);
            blog.setUserId(user.getId());
        }*/
        blog.setUserId(1);
        blog.setUserInfo(new UserInfo());
        //去除博客内容包含的网页标签,然后截取部分内容作为文章摘要
        String content = new PegDownProcessor().markdownToHtml(blog.getContent());
        String blogDesc = HtmlUtil.cleanHtmlTag(content);
        //设置文章摘要
        blog.setBlogDesc((blogDesc.length() > 150 ? blogDesc.substring(0, 150) : blogDesc) + "...");
        blog.setViewCount(0);
        blog.setCommentCount(0);
        blog.setBlogTime(new Date());
        blog.setUpdateTime(new Date());
        blogService.addBlog(blog);
        return "redirect:/admin/blog";
    }

    /**
     * 进入到文章插入界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/blog/write")
    public String addBlog(Model model) throws Exception{
        List<Category> categoryList = categoryService.findAll();
        List<Tag> tagList = tagService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("tagList",tagList);
        return "/admin/blog/write";
    }

    /**
     * 根据文章删除博客
     * @param id
     */
    @RequestMapping("/delete/{id}")
    public String deleteBlogById(@PathVariable("id")Integer id){
        blogService.deleteBlogById(id);
        return "redirect:/admin/blog";
    }

    /**
     * 修改博客的内容
     * @param id
     * @return
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView repeatWrite(@PathVariable("id")Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Blog blog = blogService.findBlogByIdAndStatus(null,id);
        //回显博客内容
        mv.addObject("blog",blog);
        //目录
        List<Category> categoryList = categoryService.findAll();
        mv.addObject("categoryList",categoryList);
        //标签
        List<Tag> tagList = tagService.findAll();
        mv.addObject("tagList",tagList);

        mv.setViewName("/admin/blog/write");
        return mv;
    }

    @RequestMapping("/blog/update")
    public String repeatSubmit(Blog blog){
        System.out.println("开始修改博客内容");
        //去除博客内容包含的网页标签,然后截取部分内容作为文章摘要
        String blogDesc = HtmlUtil.cleanHtmlTag(blog.getContent());
        //设置文章摘要
        blog.setBlogDesc((blogDesc.length() > 150 ? blogDesc.substring(0, 150) : blogDesc) + "...");
        //设置上次的更新时间
        blog.setUpdateTime(new Date());
        blogService.updateBlog(blog);
        return "redirect:/admin/blog";
    }
}
