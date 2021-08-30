package com.bailu.service.impl;

import com.bailu.dao.AdminDao;
import com.bailu.entity.AdminEntity;
import com.bailu.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 9:54
 * @description：
 * @version:
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public AdminEntity login(AdminEntity admin) {
        QueryWrapper<AdminEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",admin.getUsername());
        AdminEntity adminEntity = this.baseMapper.selectOne(wrapper);
        if (ObjectUtils.isEmpty(adminEntity)) throw new RuntimeException("用户名错误!");
        if (!admin.getPassword().equals(adminEntity.getPassword())) throw new RuntimeException("密码输入错误!");
        return adminEntity;
    }
}
