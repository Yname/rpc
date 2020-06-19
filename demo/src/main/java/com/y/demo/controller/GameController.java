package com.y.demo.controller;

import com.y.demo.entiy.GameEquip;
import com.y.demo.entiy.GameUser;
import com.y.demo.handler.GameHandler;
import com.y.demo.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

@Controller
@RequestMapping("/User")
public class GameController {

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

//  注册
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("Name") String userName,
                          @RequestParam("Pwd")String userPwd,
                          @RequestParam("Id")int phoneId,
                          Model model, HttpSession session){

        synchronized (this){
            GameUser gameUser = service.queryByUserId(phoneId);
            if (gameUser != null){
                String error = "用户名已存在！";
                model.addAttribute("error",error);
                return "error";
            }
            user.setPhone_id(phoneId);
            user.setUser_name(userName);
            user.setUser_pwd(userPwd);
            user.setVip(0);
            user.setUser_status(1);
            service.addUser(user);
        }
        model.addAttribute("gameuser",userName);
        session.setAttribute("PhoneId",phoneId);
        session.setAttribute("vip",0);
        return "success";
    }

//  注册vip
    @RequestMapping("/vip")
    public String addVip(@RequestParam("Vip")int vip,
                         Model model,HttpSession session){

        if (vip != 1){
            String error = "验证码不正确！";
            model.addAttribute("error",error);
            return "error";
        }
        Integer phoneId = (Integer) session.getAttribute("PhoneId");
        user.setPhone_id(phoneId);
        user.setVip(vip);
        gameHandler().addVip(user);
        session.setAttribute("vip",vip);
        String success = "感谢你的支持！";
        model.addAttribute("success",success);
        return loginVip();
    }

//    登录
    @RequestMapping("/loginTo")
    public String login(@RequestParam("Id")int id,
                        @RequestParam("Pwd")String pwd,
                        HttpSession session, Model model){

        GameUser gameUser = service.queryByUserId(id);
        if (gameUser == null || !pwd.equals(gameUser.getUser_pwd())){
            String error = "用户名或密码错误！";
            model.addAttribute("error",error);
            return "error";
        }
        session.setAttribute("PhoneId",id);
        int vip = gameUser.getVip();
        int equipId = gameUser.getUser_equip();
        session.setAttribute("equipId",equipId);
        session.setAttribute("vip",vip);
        model.addAttribute("gameuser",gameUser.getUser_name());
        if (vip == 1){
            return "vip/success";
        }
        return "success";
    }

//    查询
    @RequestMapping("/login/query")
    public String  queryByUserId(@RequestParam("phoneId")int id, Model model){

        GameUser gameUser1 = service.queryByUserId(id);
        model.addAttribute("gameUser1",gameUser1);
        return "function/success";
    }

    @RequestMapping("/login/queryAll")
    public String  queryByUser(@RequestParam("Name")String name,Model model){

        List<GameUser> gameUsers = service.queryByUserName(name);
        model.addAttribute("ListUser",gameUsers);
        return "function/queryUser";
    }

//    删除
    @RequestMapping("/login/deleteId")
    public String  deleteByUserId(@RequestParam("Id")int id,
                                  HttpSession session,Model model){

        if ((int)(session.getAttribute("vip")) == 1){
            String error = "权限不足";
            model.addAttribute("error",error);
            return "delete/delete";
        }
        gameHandler().deleteByUserId(id);
        return "delete/success";
    }

//    修改
    @RequestMapping("/login/updateId")
    public String  updateById(@RequestParam("Id")int id,
                              @RequestParam("Name")String name){

        user.setUser_name(name);
        user.setPhone_id(id);
        gameHandler().updateById(user);
        return "update/success";
    }

//   跳转页面
    @RequestMapping("/login_vip")
    public String login_vip(){
        return "login/login_vip";
    }

    @RequestMapping("/login/l_query")
    public String queryUser(){
        return "function/queryId";
    }

    @RequestMapping("/login/l_queryName")
    public String queryUser1(){
        return "function/queryName";
    }

    @RequestMapping("/login/l_delete")
    public String delete(){
        return "delete/delete";
    }

    @RequestMapping("/login/l_update")
    public String update(){
        return "update/update";
    }

    @RequestMapping("/l_index")
    public String loginIndex(){
        return "index";
    }

    @RequestMapping("/login/l_vip")
    public String loginVip(){
        return "vip/success";
    }

}
