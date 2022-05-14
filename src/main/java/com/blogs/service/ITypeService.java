package com.blogs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blogs.entity.Note;
import com.blogs.entity.Type;

public interface ITypeService extends IService<Type> {
    IPage<Type> getPage(int currentPage, int pageSize, Type type);
}
