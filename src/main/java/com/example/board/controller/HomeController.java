package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 해당 클래스가 컨트롤러라고 지정해주는 어노테이션
public class HomeController {
    @GetMapping("/") // 시작페이지를 정함
    public String index(){
        System.out.println("HomeController.index");
        return "index"; // index html 을 띄우겠다.
    }
}
