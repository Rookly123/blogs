package com.blogs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blogs.controller.utils.R;
import com.blogs.entity.Note;
import com.blogs.service.INoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/notes")
@Slf4j
public class NoteController {
    @Autowired
    private INoteService iNoteService;
    @GetMapping
    public R getAll()
    {
        return new R(true,iNoteService.list());
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,iNoteService.getById(id));
    }
    @PostMapping
    public R save(@RequestBody Note note)
    {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.format(date);
        date.setHours(date.getHours()+8);
        note.setPubTime(date);
        boolean flag = iNoteService.save(note);
        return new R(flag,flag?"添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody Note note)
    {
        return new R(iNoteService.updateById(note));
    }
    @DeleteMapping("{id}")
    public R remove(@PathVariable Integer id)
    {
        return new R(iNoteService.removeById(id));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Note note)
    {
        IPage<Note> page = iNoteService.getPage(currentPage,pageSize,note);
        if(currentPage > page.getPages())
        {
            page = iNoteService.getPage((int) page.getPages(),pageSize,note);
        }
        return new R(true,page);
    }
}
