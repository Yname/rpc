package com.y.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class NewUser {
    private int id;
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_book;
    private String user_friend;
    private int vip;
}
