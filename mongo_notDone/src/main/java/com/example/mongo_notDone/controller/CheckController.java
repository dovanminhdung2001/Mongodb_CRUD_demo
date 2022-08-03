package com.example.mongo_notDone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckController {
    @RequestMapping("/check")
    public String check() {
        return "check2";
    }
}
