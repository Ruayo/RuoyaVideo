package com.bailu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/20 14:11
 * @description：test
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class testController {
    @GetMapping("/api")
    public String test(){
        log.info("category success");
        return "success";
    }
}
