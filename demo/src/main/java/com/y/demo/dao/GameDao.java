package com.y.demo.dao;

import com.y.demo.entiy.GameEquip;
import com.y.demo.entiy.GameFriend;
import com.y.demo.entiy.GameUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameDao {
//    用户增删改查
    void addUser(GameUser user);
    void addVip(GameUser user);
    GameUser queryByUserId(int id);
    List<GameUser> queryByUserName(String name);
    void deleteByUserId(int id);
    void updateById(GameUser user);



//    装备
    GameEquip queryEquip( int id);
    void addEquip(GameEquip equip);
    GameEquip queryEquipByName(String name);
    GameEquip queryEquipByPhoneId(int id);
    int queryUser_Equip(int phone_id);
    void updateEquip_id(GameUser user);
    void deleteEquip(int equip_id);
    List<GameEquip> queryAllEquip();

//    friend
    GameFriend queryFriend(int friend_id);
    void deleteFriend(GameUser user);
    int queryUser_Friend(int user_friend);

}
