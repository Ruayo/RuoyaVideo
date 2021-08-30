package com.bailu.service;

import com.bailu.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 18:03
 * @description：
 * @version:
 */
public interface CategoryService extends IService<CategoryEntity> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CategoryEntity queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
   // List<CategoryEntity> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param CategoryEntity 实例对象
     * @return 实例对象
     */
    CategoryEntity insert(CategoryEntity CategoryEntity);

    /**
     * 修改数据
     *
     * @param CategoryEntity 实例对象
     * @return 实例对象
     */
    CategoryEntity update(CategoryEntity CategoryEntity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    //类别列表
    List<CategoryEntity> queryByFirstLevel();
}
