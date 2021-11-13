package com.mtbx.prgword.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

@Controller
public class CommonViewController {


    /**
     * 메인 페이지 접근
     * @return
     */
    @GetMapping("/")
    public String main() {
        return "index";
    }

}
