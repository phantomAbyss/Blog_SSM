package com.wy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.wy.blog.dao.TagDao;
import com.wy.blog.domain.Tag;
import com.wy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    public List<Tag> findAll() throws Exception {
        return tagDao.findAll();
    }

    public Integer countTag() {
        return tagDao.countTag();
    }

    public List<Tag> getTagList(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return tagDao.findAll();
    }

    public Tag getTagByTagId(Integer tagId) throws Exception {
        return tagDao.getTagByTagId(tagId);
    }
}
