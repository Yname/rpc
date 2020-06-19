package com.y.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class NewFriend {
    private String friend_id;
    private String friend_1;
    private String friend_2;
    private String friend_3;
}
