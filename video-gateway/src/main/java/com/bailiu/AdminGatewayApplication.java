package com.bailiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/20 14:23
 * @description：
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdminGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminGatewayApplication.class,args);
    }
}

