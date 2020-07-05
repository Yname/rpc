package com.game.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Jump")
public class JumpController {

    @RequestMapping("/index")
    public String jumplToIndex(){
        return "index";
    }
    @RequestMapping("/success")
    public String jumpToSuccess(){
        return "success";
    }
    @RequestMapping("/VipSuccess")
    public String jumpToVipSuccess(){
        return "vip/success";
    }
    @RequestMapping("/VipEdit")
    public String jumpToVipEdit(){
        return "vip/Edit";
    }
    @RequestMapping("/register")
    public String jumpToRegister(){ return "register";}
}
