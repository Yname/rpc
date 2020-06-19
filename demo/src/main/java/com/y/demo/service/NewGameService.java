package com.y.demo.service;

import com.y.demo.entiy.NewFriend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface NewGameService {
    void addFriend_Friend(String friend_friend_id);

    void updateNewFriend(NewFriend newFriend);

    void addFriend_Id(String friend_id);

    void addFriendField(int field);
    int queryColumnS(@Param("table") String table);
    List<String> queryTableName();
    int queryCapacity(String friend_friend_id);
//  length为扩容的长度，为5的倍数，如5,10,15
    String expandCapacity(int length,String friend_friend_id);
    int queryColumnSImpl();
//    void addField();

}
