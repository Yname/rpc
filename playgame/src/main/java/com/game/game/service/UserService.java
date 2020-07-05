package com.game.game.service;

import com.game.game.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public interface UserService {

    String addUser(User user);
    String deleteEquip(String user_id,String equip_id);
    String login(User user, HttpSession session);
    String addEquip(HttpSession session);
    String becomeVip(HttpSession session,int vip);
    String deleteAllEquip(HttpSession session);
    PageInfo getUserPageInfo(HttpSession session);
    PageInfo getEquipPageInfo(HttpSession session);
    PageInfo getAllEquipPageInfo(HttpSession session);

}
