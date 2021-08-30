package com.bailu.controller;

import com.bailu.config.RedisKeys;
import com.bailu.dto.AdminDTO;
import com.bailu.entity.AdminEntity;
import com.bailu.service.AdminService;
import com.bailu.utils.R;
import com.bailu.utils.RedisUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/23 17:52
 * @description：
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("admins")
public class adminController {
    @Resource
    private AdminService adminService;
    @Resource
    private RedisUtils redisUtils;

    @PostMapping("login")
    public Map<String, String>  tokens(@RequestParam Map<String, String> param, HttpSession session){
        HashMap<String, String> result = new HashMap<>();
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setUsername(param.get("username"));
        adminEntity.setPassword(param.get("password"));
        AdminEntity admin = adminService.login(adminEntity);
        String token = session.getId();
        Gson gson = new Gson();
        redisUtils.set(RedisKeys.TOKEN_KEY + token,admin);
        result.put("token",token);
        return result;
    }

    @GetMapping("/admin-user")
    public AdminDTO admin(String token) {
        log.info("当前token信息: {}", token);
        Gson gson = new Gson();
        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        AdminEntity admin =  gson.fromJson(redisUtils.get(RedisKeys.TOKEN_KEY + token),AdminEntity.class);
        AdminDTO adminDTO = new AdminDTO();
        //1.属性复制
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable("token") String token) {

        redisUtils.delete(RedisKeys.TOKEN_KEY + token);
    }

}
