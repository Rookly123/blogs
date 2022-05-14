package com.blogs.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blogs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
