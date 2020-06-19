package com.y.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class NewBook {

    private String book_id;
    private String book_1;
    private String book_2;
    private String book_3;
}
