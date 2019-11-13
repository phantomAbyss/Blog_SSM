package com.wy.blog.service;

public interface LinkService {


    /**
     * 根据状态获取可用的链接数量
     * @param status
     * @return
     */
    Integer countLink(Integer status);
}
