package com.blogs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blogs.entity.Note;

public interface INoteService extends IService<Note> {
    IPage<Note> getPage(int currentPage,int pageSize,Note note);
}
