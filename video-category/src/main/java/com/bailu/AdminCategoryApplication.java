package com.bailu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/7/30 15:35
 * @description：启动类
 * @version:
 */
@MapperScan("com.bailu.dao")
@SpringBootApplication
public class AdminCategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminCategoryApplication.class,args);
    }
}
