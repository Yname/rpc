package com.y.demo.service.impl;

import com.y.demo.dao.GameDao;
import com.y.demo.entiy.GameEquip;
import com.y.demo.entiy.GameFriend;
import com.y.demo.entiy.GameUser;
import com.y.demo.service.GameService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class GameServiceImpl implements GameService {
    @Resource
    private GameDao dao;

    @Resource
    private GameUser user;

//    User
    @Override
    public void addUser(GameUser user) {
        dao.addUser(user);
    }

    @Override
    public void addVip(GameUser user) {
        dao.addVip(user);
    }

    @Override
    public GameUser queryByUserId(int id) {
        user = dao.queryByUserId(id);
        return user;
    }

    @Override
    public List<GameUser> queryByUserName(String name) {
        return dao.queryByUserName(name);

    }

    @Override
    public void deleteByUserId(int id) {
        dao.deleteByUserId(id);
    }

    @Override
    public void updateById(GameUser user) {
        dao.updateById(user);
    }


    //    装备
    @Override
    public GameEquip queryEquip(int id) {
        return dao.queryEquip(id);
    }

    @Override
    public void addEquip(GameEquip equip) {
        dao.addEquip(equip);
    }

    @Override
    public GameEquip queryEquipByName(String name) {
        return dao.queryEquipByName(name);
    }

    @Override
    public GameEquip queryEquipByPhoneId(int id) {
        return dao.queryEquipByPhoneId(id);
    }

    @Override
    public int queryUser_Equip(int user_equip) {
        return dao.queryUser_Equip(user_equip);
    }

    @Override
    public void updateEquip_id(GameUser user) {
        dao.updateEquip_id(user);
    }

    @Override
    public void deleteEquip(int equip_id) {
        dao.deleteEquip(equip_id);
    }

    @Override
    public List<GameEquip> queryAllEquip() {
        return dao.queryAllEquip();
    }


//    friend
    @Override
    public GameFriend queryFriend(int friend_id) {
        return dao.queryFriend(friend_id);
    }

    @Override
    public void deleteFriend(GameUser user) {
        dao.deleteFriend(user);
    }

    @Override
    public int queryUser_Friend(int user_friend) {
        return dao.queryUser_Friend(user_friend);
    }


}
