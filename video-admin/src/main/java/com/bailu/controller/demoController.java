package com.bailu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/20 14:02
 * @description：test
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class demoController {
    @GetMapping("/api")
    public String test(){
        log.info("admin success");
        return "success";
    }
}
