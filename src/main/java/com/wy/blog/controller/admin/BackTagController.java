package com.wy.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Tag;
import com.wy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/tag")
public class BackTagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("")
    public String index(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                        Model model) throws Exception {
        List<Tag> tagList = tagService.getTagList(pageNum,pageSize);
        model.addAttribute("pageInfo",new PageInfo<Tag>(tagList));
        return "/admin/blog/tag";
    }

    @RequestMapping("/edit/{id}")
    public String editTag(@PathVariable("id") Integer tagId,
                          @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                          Model model) throws Exception {
        Tag tag = tagService.getTagByTagId(tagId);
        model.addAttribute("tag",tag);
        List<Tag> tagList = tagService.getTagList(pageNum, pageSize);
        model.addAttribute("pageInfo",new PageInfo<Tag>(tagList));
        return "/admin/blog/tag";
    }
}
