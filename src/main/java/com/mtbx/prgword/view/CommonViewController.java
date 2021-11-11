package com.mtbx.prgword.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

@Controller
public class CommonViewController {



    @GetMapping("/")
    public String main() {
        return "index";
    }

}
