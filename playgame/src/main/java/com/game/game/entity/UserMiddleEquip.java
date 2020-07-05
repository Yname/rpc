package com.game.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UserMiddleEquip {
    private int id;
    private String equip_id;
    private String user_id;
    private int equip_status;
    private int equip_field;
}
