package com.game.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {

    private String user_id;
    private String user_name;
    private String user_pwd;
    private int vip;
    private int status;
    private int equip_field;

}
