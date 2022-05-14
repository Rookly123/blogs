package com.blogs.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blogs.entity.Note;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteDao extends BaseMapper<Note> {
}
