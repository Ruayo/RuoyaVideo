package com.bailu.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 18:03
 * @description：
 * @version:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // 用在类上  用来指定json数据中包含哪些数据 JsonInclude.Include.NON_NULL 只要json中不为空的属性
public class CategoryEntity implements Serializable {
    private Integer id;
    /**
     * http://localhost:9999/category/categories     * 名称
     */
    private String name;
    /**
     * 父级分类id
     */
    //jsonproperty  不仅适用于序列化 json数据    还是用json数据反序列化
    @JsonProperty("parent_id")
    private Integer parentId;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private List<CategoryEntity> children;
}
