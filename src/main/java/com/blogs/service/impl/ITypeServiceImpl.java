package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blogs.Dao.TypeDao;
import com.blogs.entity.Type;
import com.blogs.service.ITypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITypeServiceImpl extends ServiceImpl<TypeDao, Type> implements ITypeService {
    @Autowired
    private TypeDao typeDao;
    @Override
    public IPage<Type> getPage(int currentPage, int pageSize, Type type) {
        LambdaQueryWrapper<Type> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(type.getTypeName()),Type::getTypeName,type.getTypeName());
        IPage page = new Page(currentPage,pageSize);
        typeDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
