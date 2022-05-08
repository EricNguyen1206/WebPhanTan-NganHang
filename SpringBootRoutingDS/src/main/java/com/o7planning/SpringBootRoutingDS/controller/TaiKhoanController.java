package com.o7planning.SpringBootRoutingDS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/vi/taikhoan")
public class TaiKhoanController {
    
    @GetMapping(path = "/")
    public String test(){


        return "taikhoan";
    }
}
