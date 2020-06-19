package com.y.demo.service.impl;

import com.y.demo.dao.GameFriendDao;
import com.y.demo.entiy.Constant;
import com.y.demo.entiy.FriendFriend;
import com.y.demo.entiy.NewFriend;
import com.y.demo.service.NewGameService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewGameServiceImpl implements NewGameService, Constant {

    @Resource
    private NewFriend newFriend;
    @Resource
    private GameFriendDao gameFriendDao;
    @Resource
    private FriendFriend friendFriend;



    @Override
    public void addFriend_Friend(String friend_friend_id) {
//       设置的默认容量是30
        gameFriendDao.addFriend_Friend(friend_friend_id,30);
    }

    @Override
    public void updateNewFriend(NewFriend newFriend) {
        gameFriendDao.updateNewFriend(newFriend);
    }

    @Override
    public void addFriend_Id(String friend_id) {
        gameFriendDao.addFriend_Id(friend_id);
    }

//    每次增加5个栏位
    @Override
    public void addFriendField(int field) {
        List<String> list = new ArrayList<>();
        long start = System.currentTimeMillis();
//        每次增肌5个
        for (int i = field-1; i < field+4 ; i++) {
            String friend_friend = "friend_friend_"+ i;
            list.add(friend_friend);
        }
        gameFriendDao.addFriendField(list);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
//    增加field
//    public void addField(){
////        long start = System.currentTimeMillis();
////        addFriendField(columnS);
////        long end = System.currentTimeMillis();
////        System.out.println(end - start);
////    }

    public int queryColumnSImpl(){
//        查询出所有的表
        List<String> strings = queryTableName();
        for (String s : strings
        ) {
//            根据表筛选出需要的表
            if (s.endsWith("d_1")){
//              查询出 表的 列数
                return queryColumnS(s);
            }
        }
       return 0;
    }
    @Override
    public int queryColumnS(String table) {
        return gameFriendDao.queryColumnS(table);
    }

    @Override
    public List<String> queryTableName() {
        return gameFriendDao.queryTableName();
    }

    @Override
    public int queryCapacity(String friend_friend_id) {
//        String phoneId = (String) session.getAttribute("PhoneId");
        return gameFriendDao.queryCapacity(friend_friend_id);
    }

    @Override
    public String expandCapacity(int length,String friend_friend_id) {
//        int columnS = gameFriendDao.queryColumnS(table);
        long start = System.currentTimeMillis();
//        获取容量,初始为30
        int capacity = queryCapacity(friend_friend_id);
//        最大容量为100,如果是vip，则根据vip来获取
        int vip = 0;
        int capacityNumber = 95;
        if(vip > 3){
            capacityNumber = 150;
        }
        if (capacity > capacityNumber){
            return "error";
        }
        int columnS = queryColumnSImpl();
        if (capacity > (columnS - 5)){
            return "error";
        }
        friendFriend.setFriend_friend_id(friend_friend_id);
        friendFriend.setCapacity(capacity+length);
        gameFriendDao.updateCapacity(friendFriend);
        long end = System.currentTimeMillis();
        System.out.println("expandCapacity用时："+(end - start));
        return "success";
    }


//    public void insertFriend_Friend(){
//
//    }

}
