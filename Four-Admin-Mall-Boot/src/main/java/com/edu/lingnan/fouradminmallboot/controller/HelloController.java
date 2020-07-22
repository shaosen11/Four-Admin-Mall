package com.edu.lingnan.fouradminmallboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 23:56 2020/7/21
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
