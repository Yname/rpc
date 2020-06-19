package com.y.demo.controller;

import com.y.demo.entiy.GameEquip;
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
import java.util.List;

@Controller
@RequestMapping("/Equip")
public class GameEquipController {

    @Resource
    private GameEquip equip;

    @Resource
    private GameService service;

    @Resource
    private GameUser user;

    public GameService gameHandler(){

        InvocationHandler handler = new GameHandler(service);
        service = (GameService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), handler);
        return  service;
    }

    @RequestMapping("/query")
    public String queryEquip(@RequestParam("Id")int id,Model model){

        GameEquip gameEquip = service.queryEquip(id);
        if (gameEquip == null){
            String success = "亲！没有这件装备哦！";
            model.addAttribute("success",success);
            return "success";
        }
        String equip_name = gameEquip.getEquip_name();
        model.addAttribute("equipName",equip_name);
        model.addAttribute("equipId",id);
        return "success";
    }

    @RequestMapping("/queryAll")
    public String queryAllEquip(Model model){
        List<GameEquip> gameEquips = service.queryAllEquip();
        model.addAttribute("gameEquips",gameEquips);
        return "success";
    }

    @RequestMapping("/queryName")
    public String queryEquipByName(@RequestParam("Name")String name,Model model){

        GameEquip gameEquip = service.queryEquipByName(name);
        if (gameEquip != null){
            model.addAttribute("equipId",name);
            return "success";
        }
        String equipId = "装备不存在，请输入装备的名称";
        model.addAttribute("equipId",equipId);
        return "success";
    }

    @RequestMapping("/queryById")
    public String queryEquipByPhoneId(Model model, HttpSession session){
//        int phoneId = (int) session.getAttribute("PhoneId");
        int equipId = (int) session.getAttribute("equipId");
        if (equipId == 0){
            String equip = "亲！你还没有装备！";
            model.addAttribute("equipId",equip);
            return "success";
        }
        GameEquip gameEquip = service.queryEquipByPhoneId(equipId);
        int equip_id = gameEquip.getEquip_id();
        String equip_name = gameEquip.getEquip_name();
        model.addAttribute("equipId",equip_id);
        model.addAttribute("equipName",equip_name);
        return "success";
    }

    @RequestMapping("/addEquip")
    public String addEquip(@RequestParam("Id")int id,
                           @RequestParam("Name")String name, Model model){

        if (service.queryEquip(id) != null){
            String error = "装备ID已存在！";
            model.addAttribute("error",error);
            return "error";
        }
        if (service.queryEquipByName(name) != null){
            String error = "装备名已存在！";
            model.addAttribute("error",error);
            return "error";
        }
        equip.setEquip_id(id);
        equip.setEquip_name(name);
        gameHandler().addEquip(equip);
        String success = "添加装备成功！";
        model.addAttribute("success",success);
        return "equip/success";
    }

    @RequestMapping("/update")
    public String updateEquip_id(HttpSession session,Model model,
                                 @RequestParam("Id")int equip_id){

        int phoneId = (int) session.getAttribute("PhoneId");
        if (service.queryEquip(equip_id) == null){
            String equipId = "亲！没有这件装备！";
            model.addAttribute("equipId",equipId);
            return "success";
        }
        user.setPhone_id(phoneId);
        user.setUser_equip(equip_id);
        service.updateEquip_id(user);
        return "success";
    }

//    删除装备
    @RequestMapping("/delete")
    public String  deleteEquip(@RequestParam("Id")int equip_id,Model model){

        GameEquip gameEquip = service.queryEquip(equip_id);
        if (gameEquip != null){
            String success = "删除成功！";
            model.addAttribute("success",success);
            service.deleteEquip(equip_id);
            return "vip/success";
        }
        String success = "亲！没有这件装备！";
        model.addAttribute("success",success);
        return "vip/success";
    }


//    页面跳转
    @RequestMapping("/l_equip")
    public String loginEquip(){
        return "equip/equip";
    }
    @RequestMapping("/equip_l")
    public String equipLogin(){
        return "success";
    }
}
