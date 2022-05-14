package com.blogs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class User {
    @TableId(value = "userId")
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userNick;
    private String userHead;
    private String userMood;
}
