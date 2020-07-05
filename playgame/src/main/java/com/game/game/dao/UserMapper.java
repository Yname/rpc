package com.game.game.dao;

import com.game.game.entity.Equip;
import com.game.game.entity.User;
import com.game.game.entity.UserMiddleEquip;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
//@MapperScan("mapper/*.xml")
public interface UserMapper {
    void addUser(User user);
    int queryUserById(String userId);
    List<User> queryUserByName(String userName);
    void updateVip(User user);
    User queryUser(String userId);
//    List<User> queryAllUser();
    void addEquip(UserMiddleEquip userMiddleEquip);
    int queryEquipField(String user_id);
//    int queryUserField(String user_id);
    void deleteEquip(String equip_id);
    int queryEquipExitsByEquipIdAndUserId(UserMiddleEquip equip);
    int queryEquipByEquipId(String equip_id);
    void deleteAllEquipByUserId(String user_id);
    void deleteUserByUserId(String user_id);
//    List<Equip> queryEquipByUserId(String user_id);
    List<Equip> queryAllEquipForUser(String user_id);
    void deleteEquipForEName(String equip_name);
    List<Equip> queryAllEquip();
//    void updateFieldForVip(User user);
}
