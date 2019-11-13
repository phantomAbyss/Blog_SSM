package com.wy.blog.controller.admin;

import cn.hutool.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/admin/upload")
public class UploadController {

    /**
     * 图片存放的根路径
     */
    public final String rootPath = "E:/blogImages/";

    public final String allowSuffix = ".bmp.jpg.jpeg.png.gif.pdf.doc.zip.rar.gz";


    @RequestMapping(value = "/image",produces = "application/json",method = RequestMethod.POST)
    public String uploadImage(HttpServletRequest request,HttpServletResponse response,
            @RequestParam("file")MultipartFile file) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        System.out.println("开始上传图片");
        //以map方式创建json数据，最后返回给前台显示
        Map<String,Object> map = new HashMap<String, Object>();
        //使用map存储将要显示到编辑器内部的内容
        Map<String,Object> data = new HashMap<String,Object>();
        //文件的全文件名
        String fileName = file.getOriginalFilename();
        //解决后面图片名称重复的问题
        //文件名，不包含后缀名
        String name = fileName.substring(0, fileName.indexOf('.'));
        //文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        if(allowSuffix.indexOf(suffix) == -1){
            //做文件上传错误处理
            map.put("code",1);
            map.put("msg","图片的格式不正确");
            map.put("data",null);
            return new JSONObject(map).toString();
        }
        //创建文件目录
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));
        //目标文件
        File descFile = new File(rootPath + File.separator + dateDirs + File.separator + fileName);
        int i = 1;
        //判断文件是否存在重名
        String newFileName = fileName;
        while(descFile.exists()){
            newFileName = name + "_" + i + suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath + File.separator + newFileName);
            i++;
        }
        //判断目标文件所在的目录是否存在
        if(!descFile.getParentFile().exists()){
            descFile.getParentFile().mkdirs();
        }
        //存储文件
        //将数据写入磁盘
        try {
            file.transferTo(descFile);
        } catch (Exception e){
            throw new RuntimeException("文件上传失败");
        }
        //图片的访问路径
        String fileUrl = request.getContextPath() + "/uploads/" + dateDirs + "/" + newFileName;
        //0表示图片上传成功，1表示图片上传失败
        map.put("code",0);
        //提示信息
        map.put("msg","图片上传成功");
        map.put("data",data);
        //访问图片的url
        data.put("src",fileUrl);
        //图片名称，即显示在编辑框的图片
        data.put("title",newFileName);
        //以json格式的数据返回
        return new JSONObject(map).toString();
    }

}
