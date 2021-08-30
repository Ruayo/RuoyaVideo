package com.bailu.service.impl;

import com.bailu.dao.CategoryDao;
import com.bailu.entity.CategoryEntity;
import com.bailu.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 18:02
 * @description：
 * @version:
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Resource
    private CategoryDao categoryDao;
    @Override
    public CategoryEntity queryById(Integer id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public CategoryEntity insert(CategoryEntity categoryEntity) {
        categoryEntity.setCreatedAt(new Date());
        categoryEntity.setUpdatedAt(new Date());
        this.baseMapper.insert(categoryEntity);
        return null;
    }

    @Override
    public CategoryEntity update(CategoryEntity CategoryEntity) {
        QueryWrapper<CategoryEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("id",CategoryEntity.getId());
        this.baseMapper.update(CategoryEntity,objectQueryWrapper);
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        this.baseMapper.deleteById(id);
        return false;
    }

    @Override
    public List<CategoryEntity> queryByFirstLevel() {
        List<CategoryEntity> categoryEntities = categoryDao.queryByFirstLevel();
        return  categoryEntities;
    }
}
