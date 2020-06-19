package com.y.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class GameUser {
//    private int id;
    private int phone_id;
    private String user_name;
    private String user_pwd;
    private int vip;
    private int user_status;
    private int user_equip;
    private int user_friend;
}
