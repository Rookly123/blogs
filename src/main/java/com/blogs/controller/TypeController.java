package com.blogs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blogs.controller.utils.R;
import com.blogs.entity.Note;
import com.blogs.entity.Type;
import com.blogs.service.ITypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/types")
@Slf4j
public class TypeController {
    @Autowired
    private ITypeService iTypeService;
    @GetMapping
    public R getAll()
    {
        return new R(true,iTypeService.list());
    }
    @PostMapping
    public R save(@RequestBody Type type)
    {
        boolean flag = iTypeService.save(type);
        return new R(flag,flag?"添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody Type type)
    {
        return new R(iTypeService.updateById(type));
    }
    @DeleteMapping("{id}")
    public R remove(@PathVariable Integer id)
    {
        return new R(iTypeService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,iTypeService.getById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Type type)
    {
        IPage<Type> page = iTypeService.getPage(currentPage,pageSize,type);
        if(currentPage > page.getPages())
        {
            page = iTypeService.getPage((int) page.getPages(),pageSize,type);
        }
        return new R(true,page);
    }
}
