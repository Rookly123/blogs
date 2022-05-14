package com.blogs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class Note {
    @TableId(value = "noteId")
    private Integer noteId;
    private String title;
    private String content;
    private int typeId;
    private Date pubTime;
    private float lon;
    private float lat;
}
