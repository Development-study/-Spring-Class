package com.example.demo.controller;

import com.example.demo.components.AComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AController {

    @Autowired
    AComponent a;

    @GetMapping("aa")
    public String aa(Model model) {
        a.doA();
        model.addAttribute("aa", "<span>aa입니다.</span");
        model.addAttribute("mya", "2");

        List<String> aList = Arrays.asList("홍길동", "김길동", "이길동");

        model.addAttribute("aList", aList);

        model.addAttribute("myTrue", true);
        model.addAttribute("myFalse", false);

        return "aa";
    }

}
