package com.blogs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blogs.entity.Note;
import com.blogs.entity.User;

public interface IUserService extends IService<User> {
    IPage<User> getPage(int currentPage, int pageSize, User user);
}
