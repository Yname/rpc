package com.y.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameFriend {
    private int friend_user;
    private int friend_id;
    private String friend_name;
    private int friend_status;
}
