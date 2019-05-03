package com.wenl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping(value = "/{name}")
    public String index(String name){
        System.out.println(name);
        return name;
    }

}
