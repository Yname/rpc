package com.y.demo.controller;

import com.y.demo.entiy.GameFriend;
import com.y.demo.entiy.GameUser;
import com.y.demo.handler.GameHandler;
import com.y.demo.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Controller
@RequestMapping("/Friend")
public class GameFriendController {

    @Resource
    private GameFriend friend;

    @Resource
    private GameUser user;

    @Resource
    private GameService service;

    public GameService gameHandler(){

        InvocationHandler handler = new GameHandler(service);
        service = (GameService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), handler);
        return  service;
    }

    @RequestMapping("/query")
    public String queryFriend(@RequestParam("Id")int friend_id,
                              Model model, HttpSession session) {

        GameFriend gameFriend = service.queryFriend(friend_id);
        if (gameFriend == null) {
            String Name = "亲！你没有这个好友！";
            model.addAttribute("equipId", Name);
            return "success";
        }
        int friendId = gameFriend.getFriend_id();
        String friendName = gameFriend.getFriend_name();
        model.addAttribute("equipId", friendId);
        model.addAttribute("equipName", friendName);
        return "success";
    }


    @RequestMapping("/delete")
    public String  deleteFriend(@RequestParam("Id")int friend_id,Model model,
                                HttpSession session){

        int phoneId = (int) session.getAttribute("PhoneId");
        int i = service.queryUser_Friend(phoneId);
        System.out.println(i);
        if ( i != friend_id ) {
            String Name = "亲！你没有这个好友！";
            model.addAttribute("equipId", Name);
            return "success";
        }
        user.setPhone_id(friend_id);
        user.setUser_friend(0);
        gameHandler().deleteFriend(user);
        String Name = "删除成功！";
        model.addAttribute("equipId", Name);
        return "success";
    }


}
