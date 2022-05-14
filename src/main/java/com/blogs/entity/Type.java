package com.blogs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Type {
    @TableId(value = "typeId")
    private Integer typeId;
    private String typeName;
    private Integer userId;
}
