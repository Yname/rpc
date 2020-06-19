package com.y.demo.dao;

import com.y.demo.entiy.FriendFriend;
import com.y.demo.entiy.NewFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GameFriendDao {
    void addFriend_Friend(String friend_friend_id,int capacity);
    void updateNewFriend(NewFriend newFriend);
    void addFriend_Id(String friend_id);
//    增加栏位
    void addFriendField(@Param("list") List<String> list);
//    查询表的列数
    int queryColumnS(@Param("table") String table);
    List<String> queryTableName();
    int queryCapacity(String friend_friend_id);
//    List<String> queryColumnName();

    void updateCapacity(FriendFriend friendFriend);
}
