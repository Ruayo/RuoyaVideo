package com.bailu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/7/30 15:32
 * @description：启动类
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.bailu.dao")  //扫描所有
public class AdminAdminsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminAdminsApplication.class,args);
    }
}
