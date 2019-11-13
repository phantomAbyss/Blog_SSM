package com.wy.blog.controller;

import cn.hutool.http.HtmlUtil;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Comment;
import com.wy.blog.service.BlogService;
import com.wy.blog.service.CommentService;
import com.wy.blog.utils.AddressUtils;
import com.wy.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("")
    public String findAllComment(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                 Model model) throws Exception{
        PageInfo<Comment> pageInfo = commentService.findAllComment(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blog/comment";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addComment(HttpServletRequest request,Comment comment){
        //添加评论
        comment.setCommentTime(new Date());
        //获取评论者的ip地址
        comment.setCommentIp(AddressUtils.getIpAddress(request));
        //0表示访客，1表示博主
        if (request.getSession().getAttribute("user") != null) {
            comment.setCommentRole(1);
        } else {
            comment.setCommentRole(0);
        }
        //设置头像路径
        comment.setCommentAuthorAvatar(StringUtils.getAvatar(comment.getCommentAuthorEmail()));
        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //添加评论
            commentService.addComment(comment);
            //更新文章的评论数,1表示已经发布的文章,0表示还是草稿的文章
//        Blog blog = blogService.findBlogByIdAndStatus(1, comment.getCommentArticleId());
            blogService.updateCommentCount(comment.getCommentArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","评论添加失败");
            map.put("code",0);
            map.put("data",null);
            return new JSONObject(map).toString();
        }
        map.put("msg","评论添加成功");
        map.put("code",1);
        map.put("data",null);
        return new JSONObject(map).toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteComment(@PathVariable("id")Integer commentId,Model model) throws Exception{
        commentService.deleteCommentByCommentId(commentId);
        return "redirect:/comment";
    }


}
