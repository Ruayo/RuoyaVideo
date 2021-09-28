package com.bailu.controller;

import com.bailu.entity.CategoryEntity;
import com.bailu.service.CategoryService;
import com.bailu.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/30 17:26
 * @description：
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //删除类别
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("删除类别id: {}", id);
        categoryService.deleteById(id);
    }

    //添加类别接口
    @PostMapping
    public CategoryEntity save(@RequestBody CategoryEntity categoryEntity) {
        log.info("添加类别信息: {}", JSONUtils.writeJSON(categoryEntity));
        categoryEntity = categoryService.insert(categoryEntity);
        log.info("添加之后类别信息: {}", JSONUtils.writeJSON(categoryEntity));
        return categoryEntity;
    }

    //修改列表接口
    @PatchMapping("/{id}")  //{"name":"","parent_id":..}
    public CategoryEntity update(@PathVariable("id") Integer id, @RequestBody CategoryEntity categoryEntity) {
        log.info("更新类别id: {}", id);
        log.info("更新类别信息: {}", JSONUtils.writeJSON(categoryEntity));
        //1.更新
        categoryEntity.setId(id);
        return categoryService.update(categoryEntity);
    }

    //类别列表
    @GetMapping
    public List<CategoryEntity> categories() {
        return categoryService.queryByFirstLevel();
    }
}
