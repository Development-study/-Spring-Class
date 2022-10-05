package com.dgsw.mybatis.controller;

import com.dgsw.mybatis.dto.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    // select 해서 테이블 내용 뿌려주는거
    @GetMapping("findall")
    public String findall(Model model){
        System.out.println("findall");

        List<Test> testlist = sqlSessionTemplate.selectList("test.findall");

        model.addAttribute("a","10");
        model.addAttribute("testlist", testlist);

        return "findall";
    }
    //insert 해서 테이블에 행 삽입
    @GetMapping("insert")
    public String insert(Test test){
        return "insert";
    }

    @PostMapping("insert")
    public String pinsert(@Valid Test test, BindingResult bindingResult, Model model){
        System.out.println("insert");
        if( bindingResult.hasErrors()){
            System.out.println("에러 있음");
            return "insert";
        }

        sqlSessionTemplate.insert("test.inserttest", test);
        return "redirect:/board/findall";
    }

    @PostMapping("delete")
    public String delete(@RequestParam(required = false) List<Integer> check) {
        System.out.println("delete");
        check.forEach(idx -> sqlSessionTemplate.delete("test.delete", idx));

        return "redirect:/board/findall";
    }
}
