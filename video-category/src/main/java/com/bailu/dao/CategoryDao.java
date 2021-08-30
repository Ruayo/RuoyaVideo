package com.bailu.dao;

import com.bailu.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 18:09
 * @description：
 * @version:
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

    //查询类别
    List<CategoryEntity> queryByFirstLevel();
}
