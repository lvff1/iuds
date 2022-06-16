package com.swb.springbootexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: UserController
 * @author: 流沐颖
 * @date:2022/6/16 8:41
 * @description:
 * @version: study
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getAll")
    public String getAll(){
        return "ok";
    }
}
