package com.wy.blog.service.impl;

import com.wy.blog.dao.LinkDao;
import com.wy.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("linkService")
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;
    
    public Integer countLink(Integer status) {
        return linkDao.countLink(status);
    }
}
