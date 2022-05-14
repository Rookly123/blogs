package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blogs.Dao.NoteDao;
import com.blogs.entity.Note;
import com.blogs.service.INoteService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class INoteServiceImpl extends ServiceImpl<NoteDao, Note> implements INoteService {
    @Autowired
    private NoteDao noteDao;
    @Override
    public IPage<Note> getPage(int currentPage, int pageSize, Note note) {
        LambdaQueryWrapper<Note> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(note.getTitle()),Note::getTitle,note.getTitle());
        IPage<Note> page = new Page(currentPage,pageSize);
        noteDao.selectPage(page, lambdaQueryWrapper);
        return page;
    }
}
