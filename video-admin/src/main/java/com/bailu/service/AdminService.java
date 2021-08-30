package com.bailu.service;

import com.bailu.entity.AdminEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 9:54
 * @description：
 * @version:
 */
public interface AdminService extends IService<AdminEntity> {

    AdminEntity login(AdminEntity admin);

}
