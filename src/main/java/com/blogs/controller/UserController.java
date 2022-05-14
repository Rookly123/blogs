package com.blogs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blogs.controller.utils.R;
import com.blogs.entity.Note;
import com.blogs.entity.User;
import com.blogs.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping
    public R getAll()
    {
        return new R(true,iUserService.list());
    }
    @PostMapping
    public R save(@RequestBody User user)
    {
        boolean save = iUserService.save(user);
        return new R(save,save?"添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody User user)
    {
        return new R(iUserService.updateById(user));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id)
    {
        return new R(iUserService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,iUserService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, User user)
    {
        IPage<User> page = iUserService.getPage(currentPage,pageSize,user);
        if(currentPage > page.getPages())
        {
            page = iUserService.getPage((int) page.getPages(),pageSize,user);
        }
        return new R(true,page);
    }
}
