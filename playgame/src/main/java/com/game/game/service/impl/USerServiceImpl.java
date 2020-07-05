package com.game.game.service.impl;

import com.game.game.dao.UserMapper;
import com.game.game.entity.User;
import com.game.game.entity.UserMiddleEquip;
import com.game.game.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Component
@Slf4j
public class USerServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private User user1;
    @Resource
    private UserMiddleEquip userMiddleEquip;

    @Override
    public String addUser(User user) {
        int i = userMapper.queryUserById(user.getUser_id());
        if (i >= 1){
            return null;
        }
        userMapper.addUser(user);

        return "success";
    }

    @SneakyThrows
    public String login(User user,HttpSession session){

        user1 = userMapper.queryUser(user.getUser_id());
        if (user1 == null
                || !user1.getUser_name().equals(user.getUser_name())
                || !user1.getUser_pwd().equals(user.getUser_pwd())){
            return "error";
        }
        session.setAttribute("USERID",user1.getUser_id());
        session.setAttribute("VIP",user1.getVip());

        if (user1.getVip() != 0){
            log.info(user1.getUser_id()+"****VIP登录！"+new Date().getTime());
            return "vip";
        }
//        log.info(user1.getUser_id()+"在"+ Inet4Address.getLocalHost() +"****登录！"+ new Date());
        return "success";
    }

    public String becomeVip(HttpSession session,int vip1){
        int vip = (int) session.getAttribute("VIP");
        if (vip == 1){
            return "already";
        }
        user1.setUser_id((String) session.getAttribute("USERID"));
        user1.setVip(vip1);
        user1.setEquip_field(60);
        userMapper.updateVip(user1);
        return "success";
    }
//  对所有的用户进行分页
    public PageInfo getUserPageInfo(HttpSession session){
        return new PageInfo(userMapper.queryUserByName((String) session.getAttribute("TempName")));
    }

//  对用户拥有的装备进行分页
    public PageInfo getEquipPageInfo(HttpSession session){
//        Equip equip = new Equip();
//        equip.getUserMiddleEquip().getEquip_status();
        return new PageInfo(userMapper.queryAllEquipForUser((String) session.getAttribute("USERID")));
    }

//    对所有的装备进行分页
    public PageInfo getAllEquipPageInfo(HttpSession session){
        return new PageInfo(userMapper.queryAllEquip());
    }


    public String addEquip(HttpSession session){

        String user_id = (String) session.getAttribute("USERID");
//        user_id为空
        int i = userMapper.queryEquipByEquipId((String) session.getAttribute("EQUIPID"));
        if (i <= 0){
            return "error";
        }
//        user的栏位容量
        int EquipField = userMapper.queryEquipField(user_id);
//        不是vip，装备容量已达最大值
        if ((EquipField >= 30) && ((int)session.getAttribute("VIP") == 0)){
            return "full";
        }
//        装备栏的最大值
        if (EquipField >= 60){
            return "AllFull";
        }

        userMiddleEquip.setUser_id(user_id);
        userMiddleEquip.setEquip_id((String) session.getAttribute("EQUIPID"));
        userMiddleEquip.setEquip_status(10);
        userMapper.addEquip(userMiddleEquip);
        return "success";
    }


    public String deleteEquip(String user_id,String equip_id){

        userMiddleEquip.setUser_id(user_id);
        userMiddleEquip.setEquip_id(equip_id);
        int i = userMapper.queryEquipExitsByEquipIdAndUserId(userMiddleEquip);
        if (i <= 0){
            return "error";
        }
        userMapper.deleteEquip(equip_id);
        return "success";
    }

    public String deleteAllEquip(HttpSession session){
        String userid = (String) session.getAttribute("USERID");
        int field = userMapper.queryEquipField(userid);
        if (field <= 0){
            return "error";
        }
        userMapper.deleteAllEquipByUserId(userid);
        return "success";
    }






}
