package com.wy.blog.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Category;
import com.wy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class BackCategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("")
    public String getCategoryList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  Model model) throws Exception {
        List<Category> categoryList = categoryService.getCategoryList(pageNum,pageSize);
        model.addAttribute("pageInfo",new PageInfo<Category>(categoryList));
        return "/admin/blog/category";
    }

    @RequestMapping("/edit/{id}")
    public String editorCategory(@PathVariable("id") Integer categoryId,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                 Model model) throws Exception {
        //查询需要编辑的分类信息
        Category category = categoryService.getCategoryById(categoryId);
        model.addAttribute("category",category);
        List<Category> categoryList = categoryService.getCategoryList(pageNum,pageSize);
        model.addAttribute("pageInfo",new PageInfo<Category>(categoryList));
        return "/admin/blog/category";

    }
}
