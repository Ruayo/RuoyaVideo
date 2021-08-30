package com.bailu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 9:56
 * @description：
 * @version:
 */
@Data
@TableName("admin")
public class AdminEntity implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户头像地址
     */
    private String avatar;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 删除时间
     */
    private Date deletedAt;

}
