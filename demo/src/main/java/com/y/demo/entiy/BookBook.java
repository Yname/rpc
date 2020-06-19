package com.y.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class BookBook {
    private String book_book_id;
    private int book_book_field1;
    private int book_book_field2;
    private int book_book_field3;
    private int book_book_field4;
    private int book_book_field5;
}
